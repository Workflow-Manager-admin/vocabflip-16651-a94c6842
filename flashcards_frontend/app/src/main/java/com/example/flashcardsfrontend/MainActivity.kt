package com.example.flashcardsfrontend

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.flashcardsfrontend.ui.flashcardlist.FlashcardListFragment
import com.example.flashcardsfrontend.viewmodel.FlashcardViewModel

/**
 * Main entry activity for the Flashcards App.
 * Handles fragment navigation and hosts ViewModel.
 */
class MainActivity : AppCompatActivity() {

    // PUBLIC_INTERFACE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initial navigation to flashcard list fragment
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(
                    R.id.container,
                    FlashcardListFragment.newInstance()
                )
            }
        }
    }
}
