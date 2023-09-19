package com.example.roomdbtutorial.data

import com.example.roomdbtutorial.data.daos.WordDao
import com.example.roomdbtutorial.data.models.Word
import javax.inject.Inject

class WordRepository @Inject constructor(private val wordDao: WordDao) {

    suspend fun insertWord(word: Word) {
        wordDao.insertWord(word)
    }

    fun getAllWords() = wordDao.getAllWords()
}