package com.example.androidarchexample

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val allNotes : LiveData<List<Note>> = repository.allNotes.asLiveData()

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    fun update(note: Note) = viewModelScope.launch {
        repository.update(note)
    }

    fun delete(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }

    fun deleteAllNotes() = viewModelScope.launch {
        repository.deleteAllNotes()
    }

    class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NoteViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}