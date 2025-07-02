package com.example.flashcardsfrontend.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.flashcardsfrontend.data.FlashcardDatabase
import com.example.flashcardsfrontend.data.FlashcardEntity
import com.example.flashcardsfrontend.repository.FlashcardRepository
import kotlinx.coroutines.launch

/**
 * ViewModel for managing flashcard data, shuffling, and review mode.
 */
class FlashcardViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FlashcardRepository
    val allFlashcards: LiveData<List<FlashcardEntity>>
    private var _shuffledFlashcards = MutableLiveData<List<FlashcardEntity>?>()
    val shuffledFlashcards: LiveData<List<FlashcardEntity>?> = _shuffledFlashcards

    init {
        val dao = FlashcardDatabase.getDatabase(application).flashcardDao()
        repository = FlashcardRepository(dao)
        allFlashcards = repository.allFlashcards
    }

    // PUBLIC_INTERFACE
    fun insert(flashcard: FlashcardEntity) = viewModelScope.launch {
        repository.insert(flashcard)
    }

    // PUBLIC_INTERFACE
    fun update(flashcard: FlashcardEntity) = viewModelScope.launch {
        repository.update(flashcard)
    }

    // PUBLIC_INTERFACE
    fun delete(flashcard: FlashcardEntity) = viewModelScope.launch {
        repository.delete(flashcard)
    }

    // PUBLIC_INTERFACE
    fun shuffleFlashcards() {
        _shuffledFlashcards.value = allFlashcards.value?.shuffled()
    }
}
