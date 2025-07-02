package com.example.flashcardsfrontend.repository

import androidx.lifecycle.LiveData
import com.example.flashcardsfrontend.data.FlashcardDao
import com.example.flashcardsfrontend.data.FlashcardEntity

/**
 * Repository for flashcards, abstracts the data operations.
 */
class FlashcardRepository(private val dao: FlashcardDao) {

    // PUBLIC_INTERFACE
    val allFlashcards: LiveData<List<FlashcardEntity>> = dao.getAllFlashcards()

    // PUBLIC_INTERFACE
    suspend fun insert(flashcard: FlashcardEntity) = dao.insert(flashcard)

    // PUBLIC_INTERFACE
    suspend fun update(flashcard: FlashcardEntity) = dao.update(flashcard)

    // PUBLIC_INTERFACE
    suspend fun delete(flashcard: FlashcardEntity) = dao.delete(flashcard)
}
