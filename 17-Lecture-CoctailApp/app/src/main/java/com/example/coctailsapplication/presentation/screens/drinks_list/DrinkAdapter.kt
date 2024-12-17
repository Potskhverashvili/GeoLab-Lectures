package com.example.coctailsapplication.presentation.screens.drinks_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coctailsapplication.databinding.ItemDrinkBinding
import com.example.coctailsapplication.domain.model.DrinksList

class DrinkAdapter :
    ListAdapter<DrinksList.Drink, DrinkAdapter.DrinkViewHolder>(DrinkItemCallBack()) {


    // ------------------------- Override Methods ---------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DrinkViewHolder(
        ItemDrinkBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    // ------------------- ViewHolder --------------------
    class DrinkViewHolder(private val binding: ItemDrinkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(drink: DrinksList.Drink) = with(binding) {
            Glide.with(drinkImageView)
                .load(drink.imageUrl)
                .into(drinkImageView)

            nameTextView.text = drink.name
            instructionTextView.text = drink.instructions
        }
    }

    // ------------------- DiffUtils ----------------------
    class DrinkItemCallBack : DiffUtil.ItemCallback<DrinksList.Drink>() {
        override fun areItemsTheSame(
            oldItem: DrinksList.Drink,
            newItem: DrinksList.Drink,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: DrinksList.Drink,
            newItem: DrinksList.Drink,
        ) = oldItem == newItem
    }
}