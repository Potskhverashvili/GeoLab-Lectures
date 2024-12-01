package com.example.presentation.screens.add_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.Note
import com.example.data.NotesRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class AddNotesViewModel : ViewModel() {

    // Repo inj
    private val notesRepository = NotesRepository()

    // Create flow
    val noteSavedFlow = MutableSharedFlow<Boolean>()

    fun saveNote(
        title: String,
        description: String,
    ) = viewModelScope.launch {
        notesRepository.saveNote(
            Note(
                title = title,
                description = description
            )
        )
        noteSavedFlow.emit(true)
    }
}
