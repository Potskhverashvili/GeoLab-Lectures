package com.example.data

import com.example.NoteApplication
import com.example.data.local.Note
import com.example.data.local.NotesDatabase
import kotlinx.coroutines.flow.Flow

class NotesRepository {
    private val notesDao = NotesDatabase.create(NoteApplication.context).noteDao

    // Save
    suspend fun saveNote(note: Note){
        notesDao.saveNote(note)
    }

    // Update
    suspend fun deleteNote(note: Note){
        notesDao.deleteNote(note)
    }

    // Get
    fun getNotesFlow() : Flow<List<Note>>{
        return notesDao.collectNotes()
    }


}