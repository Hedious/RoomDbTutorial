package com.example.roomdbtutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdbtutorial.data.WordRepository
import com.example.roomdbtutorial.data.models.Word
import kotlinx.coroutines.launch

class MainViewModel(val wordRepo: WordRepository) : ViewModel() {
//    private lateinit var wordRepo: WordRepository
//
//    fun setRepository(wordRepository: WordRepository) {
//        wordRepo = wordRepository
//    }

    fun getAllWords() = wordRepo.getAllWords().asLiveData(viewModelScope.coroutineContext)


    fun addWord(word: String) = viewModelScope.launch() {
        wordRepo.insertWord(Word(word = word))
    }
}