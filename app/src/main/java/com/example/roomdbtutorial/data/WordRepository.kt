package com.example.roomdbtutorial.data

import com.example.roomdbtutorial.data.models.Word

class WordRepository(private val wordDatabase: WordDatabase) {

    suspend fun insertWord(word: Word) {
        wordDatabase.wordDao().insertWord(word)
    }

    fun getAllWords() = wordDatabase.wordDao().getAllWords()
}