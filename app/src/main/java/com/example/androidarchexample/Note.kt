package com.example.androidarchexample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(title : String, description: String, priority : Int) {
    @PrimaryKey(autoGenerate = true)
    private var id : Int = 0

    private var title : String = title

    private var description : String = description

    private var priority : Int = priority

    /** SETTER FUNCTIONS****/
    fun setId(id : Int) {
        this.id = id
    }

    /** GETTER FUNCTIONS ****/
    fun getId() : Int { return id }
    fun getTitle() : String { return title }
    fun getDescription() : String { return description }
    fun getPriority() : Int { return priority }
}