package com.example.roomdbtutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdbtutorial.data.WordRepository
import com.example.roomdbtutorial.data.models.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val wordRepo: WordRepository) : ViewModel() {

    fun getAllWords() = wordRepo.getAllWords().asLiveData(viewModelScope.coroutineContext)


    fun addWord(word: String) = viewModelScope.launch() {
        wordRepo.insertWord(Word(word = word))
    }
}