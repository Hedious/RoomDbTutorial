package com.example.roomdbtutorial.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "word_tbl", indices = [Index(value = ["word"], unique = true)])
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String = "",
    val createdDate: Date = Date(),

    ) {

    //constructor(wordValue: String) : this(word = wordValue)

    @Ignore
    var counter: Int = 0

}
