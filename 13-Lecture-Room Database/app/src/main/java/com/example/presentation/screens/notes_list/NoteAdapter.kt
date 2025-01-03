package com.example.presentation.screens.notes_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.data.local.Note
import com.example.roomdatabase.databinding.ItemNoteBinding

class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteViewHolder>(NoteItemCallBack()) {

    // ----------------------------- ViewHolder ------------------------
    class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) = with(binding) {
            titleTextView.text = note.title
            descriptionTextView.text = note.description
        }
    }

    // ------------------- DiffUtil CallBack ----------------
    class NoteItemCallBack : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
    }

    // ------------------------ Override Methods ------------------------------
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
        holder.bind(getItem(position))
    }


}