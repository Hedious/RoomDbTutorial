package com.example.roomdbtutorial.di

import android.content.Context
import androidx.room.Room
import com.example.roomdbtutorial.data.WordDatabase
import com.example.roomdbtutorial.data.daos.WordDao
import com.example.roomdbtutorial.data.models.Word
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    fun provideWordDatabase(@ApplicationContext context: Context): WordDatabase {
        return Room.databaseBuilder(context, WordDatabase::class.java, "word").build()
    }

    @Provides
    fun provideWordDao(wordDatabase: WordDatabase): WordDao {
        return wordDatabase.wordDao()
    }
}