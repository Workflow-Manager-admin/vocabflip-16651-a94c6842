package com.example.flashcardsfrontend.ui.flashcardlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcardsfrontend.data.FlashcardEntity
import com.example.flashcardsfrontend.databinding.ItemFlashcardBinding

class FlashcardAdapter(
    private val onItemClick: (FlashcardEntity) -> Unit,
    private val onDeleteClick: (FlashcardEntity) -> Unit
) : ListAdapter<FlashcardEntity, FlashcardAdapter.FlashcardViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashcardViewHolder {
        val binding = ItemFlashcardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlashcardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlashcardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FlashcardViewHolder(private val binding: ItemFlashcardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: FlashcardEntity) {
            binding.textWord.text = card.word
            binding.root.setOnClickListener { onItemClick(card) }
            binding.btnDelete.setOnClickListener { onDeleteClick(card) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FlashcardEntity>() {
            override fun areItemsTheSame(oldItem: FlashcardEntity, newItem: FlashcardEntity) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: FlashcardEntity, newItem: FlashcardEntity) = oldItem == newItem
        }
    }
}
