package com.example.roomdbtutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdbtutorial.data.WordRepository
import com.example.roomdbtutorial.data.models.Word
import com.example.roomdbtutorial.data.useCases.AddWordToDeviceUseCase
import com.example.roomdbtutorial.data.useCases.GetAllWordsInDeviceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllWordsInDeviceUseCase: GetAllWordsInDeviceUseCase,
    private val addWordToDeviceUseCase: AddWordToDeviceUseCase
) :
    ViewModel() {

    fun getAllWords() =
        getAllWordsInDeviceUseCase().asLiveData(viewModelScope.coroutineContext)


    fun addWord(word: String) = viewModelScope.launch() {
        addWordToDeviceUseCase(Word(word = word))
    }
}