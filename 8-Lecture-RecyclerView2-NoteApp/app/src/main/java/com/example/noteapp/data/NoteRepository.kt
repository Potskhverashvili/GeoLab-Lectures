package com.example.noteapp.data

object NoteRepository {

    private val notes = mutableListOf<Note>()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun removeNote(note: Note) {
        notes.remove(note)
    }

    fun getNote(): List<Note> {
        return notes.toList()
    }
}