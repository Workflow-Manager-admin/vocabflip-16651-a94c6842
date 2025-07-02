package com.example.flashcardsfrontend.ui.flashcardlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flashcardsfrontend.R
import com.example.flashcardsfrontend.data.FlashcardEntity
import com.example.flashcardsfrontend.databinding.FragmentFlashcardListBinding
import com.example.flashcardsfrontend.viewmodel.FlashcardViewModel

/**
 * Fragment displaying a list of flashcards.
 */
class FlashcardListFragment : Fragment() {

    private var _binding: FragmentFlashcardListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FlashcardViewModel
    private lateinit var adapter: FlashcardAdapter

    // PUBLIC_INTERFACE
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlashcardListBinding.inflate(inflater, container, false)
        return binding.root
    }

    // PUBLIC_INTERFACE
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FlashcardViewModel::class.java]
        adapter = FlashcardAdapter(
            onItemClick = { /* navigate to detail/edit */ },
            onDeleteClick = { flashcard -> viewModel.delete(flashcard) }
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.allFlashcards.observe(viewLifecycleOwner, Observer { cards ->
            adapter.submitList(cards)
            binding.emptyState.visibility = if (cards.isEmpty()) View.VISIBLE else View.GONE
        })

        binding.fabAdd.setOnClickListener {
            // Show dialog or navigate to add/edit
        }
        binding.btnShuffle.setOnClickListener {
            viewModel.shuffleFlashcards()
            // Use shuffledFlashcards LiveData if needed
        }
    }

    // PUBLIC_INTERFACE
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = FlashcardListFragment()
    }
}
