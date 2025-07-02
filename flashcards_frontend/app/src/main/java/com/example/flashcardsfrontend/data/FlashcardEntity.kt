package com.example.flashcardsfrontend.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Flashcard entity representing a word-definition pair.
 */
@Entity(tableName = "flashcards")
data class FlashcardEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val word: String,
    val definition: String
)
