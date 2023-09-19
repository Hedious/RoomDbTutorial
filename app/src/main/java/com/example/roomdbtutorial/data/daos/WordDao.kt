package com.example.roomdbtutorial.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdbtutorial.data.models.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert
    suspend fun insertWord(word: Word): Long

    @Insert
    suspend fun insertWords(word: List<Word>): List<Long>

    @Delete
    suspend fun removeWord(word: Word): Int

//    @Delete
//    suspend fun removeWords(word: List<Word>): List<Long>

    @Update
    suspend fun updateWord(word: Word): Int

    @Query("SELECT * FROM word_tbl ")
    fun getAllWords(): Flow<List<Word>>
}