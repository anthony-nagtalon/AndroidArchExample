package com.example.androidarchexample

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Update
    fun update(note : Note)

    @Delete
    fun delete(note : Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    fun getAllNotes() : Flow<List<Note>>
}