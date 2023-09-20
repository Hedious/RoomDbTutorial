package com.example.roomdbtutorial

import com.example.roomdbtutorial.data.WordLocalDataSource
import com.example.roomdbtutorial.data.daos.WordDao
import com.example.roomdbtutorial.data.models.Word
import kotlinx.coroutines.flow.Flow

class RoomWordDataSource(private val wordDao: WordDao) : WordLocalDataSource {
    override fun getAllWords(): Flow<List<Word>> {
        return wordDao.getAllWords()
    }

    override suspend fun insertWord(word: Word): Long {
        return wordDao.insertWord(word)
    }
}