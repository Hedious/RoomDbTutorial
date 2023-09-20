package com.example.roomdbtutorial.data.useCases

import com.example.roomdbtutorial.data.WordRepository
import com.example.roomdbtutorial.data.models.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllWordsInDeviceUseCase @Inject constructor(private val wordRepository: WordRepository) {
    operator fun invoke(): Flow<List<Word>> {
        return wordRepository.getAllWords()
    }
}