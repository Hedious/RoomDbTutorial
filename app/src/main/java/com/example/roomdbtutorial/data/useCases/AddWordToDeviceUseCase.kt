package com.example.roomdbtutorial.data.useCases

import com.example.roomdbtutorial.data.WordRepository
import com.example.roomdbtutorial.data.models.Word
import javax.inject.Inject

class AddWordToDeviceUseCase @Inject constructor(private val wordRepository: WordRepository) {

    suspend operator fun invoke(word: Word) {
        wordRepository.insertWord(word)
    }

}