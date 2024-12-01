package com.example.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Data Access Object
@Dao
interface NoteDao {
    // (onConflict = OnConflictStrategy.REPLACE)
    @Insert
    suspend fun saveNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM notes")
    fun collectNotes(): Flow<List<Note>>

    // alternative
    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<Note>
}