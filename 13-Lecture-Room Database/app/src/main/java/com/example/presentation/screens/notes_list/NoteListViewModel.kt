package com.example.presentation.screens.notes_list

import androidx.lifecycle.ViewModel
import com.example.data.NotesRepository

class NoteListViewModel : ViewModel() {

    // Repo inj
    private val notesRepository = NotesRepository()

    // Flow
    val notesFlow = notesRepository.getNotesFlow()

}