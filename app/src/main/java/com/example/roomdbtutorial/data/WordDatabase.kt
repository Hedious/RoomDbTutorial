package com.example.roomdbtutorial.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomdbtutorial.data.converters.RoomConverters
import com.example.roomdbtutorial.data.daos.WordDao
import com.example.roomdbtutorial.data.models.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

}