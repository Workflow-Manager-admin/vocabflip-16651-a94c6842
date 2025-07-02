package com.example.flashcardsfrontend.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Data access object for flashcards.
 */
@Dao
interface FlashcardDao {

    // PUBLIC_INTERFACE
    @Query("SELECT * FROM flashcards ORDER BY id DESC")
    fun getAllFlashcards(): LiveData<List<FlashcardEntity>>

    // PUBLIC_INTERFACE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(flashcard: FlashcardEntity): Long

    // PUBLIC_INTERFACE
    @Update
    suspend fun update(flashcard: FlashcardEntity)

    // PUBLIC_INTERFACE
    @Delete
    suspend fun delete(flashcard: FlashcardEntity)
}
