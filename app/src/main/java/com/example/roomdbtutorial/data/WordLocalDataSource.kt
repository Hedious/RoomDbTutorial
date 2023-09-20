package com.example.roomdbtutorial.data

import com.example.roomdbtutorial.data.models.Word
import kotlinx.coroutines.flow.Flow

interface WordLocalDataSource {
    fun getAllWords(): Flow<List<Word>>
    suspend fun insertWord(word: Word) : Long
}