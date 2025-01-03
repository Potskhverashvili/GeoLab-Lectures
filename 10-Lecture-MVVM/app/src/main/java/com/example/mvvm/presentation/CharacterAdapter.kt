package com.example.mvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm.data.model.CharactersList
import com.example.mvvm.databinding.ItemCharacterBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    // ----------- Property --------------
    private var currentCharactersList = emptyList<CharactersList.CharacterItem>()

    // ----------- Set Adapter List ------------
    fun setCharactersList(newCharactersList: List<CharactersList.CharacterItem>) {
        currentCharactersList = newCharactersList
        notifyDataSetChanged()

    }

    // -------------------- View Holder -------------
    class CharacterViewHolder(
        private val binding: ItemCharacterBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharactersList.CharacterItem) = with(binding) {

            nameTextView.text = character.name
            statusTextView.text = character.status

            Glide.with(characterImageView)
                .load(character.image)
                .into(characterImageView)
        }
    }

    //------------------------ Override Methods --------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(currentCharactersList[position])
    }

    override fun getItemCount() = currentCharactersList.size
}