package com.example.noteapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.data.Note
import com.example.noteapp.databinding.ItemNoteBinding

class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    // ---------------------------------- Properties ----------------------------------
    // --- to save notes ---
    private var notes = listOf<Note>()

    // --- for delete button ---
    var onDeleteClick: (Note) -> Unit = {}

    // -------------------------------- Override Methods -----------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.displayNote(notes[position])

    }

    override fun getItemCount() = notes.size


    // ---------------------------------- ViewHolder ----------------------------------
    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun displayNote(note: Note) = with(binding) {
            titleTextView.text = note.title
            descriptionText.text = note.description
            deleteImageView.setOnClickListener {
                onDeleteClick(note)
            }
        }
    }

    // ----------------------------------------- Functions -----------------------------------------
    // --- Updates notes list ---
    fun updateNotes(newNotesList: List<Note>) {
        val callBack = NoteCallBack(notes, newNotesList)

        val diffResult = DiffUtil.calculateDiff(callBack)
        notes = newNotesList

        diffResult.dispatchUpdatesTo(this)
    }


    // --- Compare new and old notes ---
    class NoteCallBack(
        private val oldList: List<Note>,
        private val newList: List<Note>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldNote = oldList[oldItemPosition]
            val newNote = newList[newItemPosition]
            return oldNote.id == newNote.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldNote = oldList[oldItemPosition]
            val newNote = newList[newItemPosition]
            return oldNote == newNote
        }
    }
}