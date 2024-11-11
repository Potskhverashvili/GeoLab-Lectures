package com.example.noteapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp.data.Note
import com.example.noteapp.data.NoteRepository
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // binding
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // adapter instance
    private val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        setListener()
    }

    // --------- RecyclerView Method --------------
    private fun initRecyclerView() {
        binding.noteRecyclerView.adapter = noteAdapter
    }


    // --------- Set Listener ------------
    private fun setListener() = with(binding) {
        // - Create Button SetListener -
        createButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            NoteRepository.addNote(Note(title = title, description = description))
            noteAdapter.updateNotes(NoteRepository.getNote())
        }

        // --- Delete ---
        noteAdapter.onDeleteClick = { note ->
            NoteRepository.removeNote(note)
            noteAdapter.updateNotes(NoteRepository.getNote())
        }
    }
}
