package com.example.myenglishapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.englishapp.databinding.ItemFavoriteBinding


class WordAdapter(
    private val words: List<String>
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    class WordViewHolder(val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemFavoriteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.binding.wordText.text = words[position]
    }

    override fun getItemCount(): Int = words.size
}