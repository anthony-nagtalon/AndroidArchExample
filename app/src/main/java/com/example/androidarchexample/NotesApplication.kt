package com.example.androidarchexample

import android.app.Application

class NotesApplication : Application() {
    val database by lazy { NoteDB.getDatabase(this) }
    val repository by lazy { NoteRepository(database.noteDao()) }
}