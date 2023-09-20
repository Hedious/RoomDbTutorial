package com.example.roomdbtutorial.data

import com.example.roomdbtutorial.data.daos.WordDao
import com.example.roomdbtutorial.data.models.Word
import javax.inject.Inject

class WordRepository @Inject constructor(private val localDataSource: WordLocalDataSource) {

    suspend fun insertWord(word: Word) {
        localDataSource.insertWord(word)
    }

    fun getAllWords() = localDataSource.getAllWords()
}