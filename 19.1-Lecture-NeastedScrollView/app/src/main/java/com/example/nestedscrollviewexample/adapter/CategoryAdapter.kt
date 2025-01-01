package com.example.nestedscrollviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedscrollviewexample.data.Category
import com.example.nestedscrollviewexample.databinding.ItemCategoryBinding

class CategoryAdapter :
    ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryItemCallBack()) {

    // ------------------------- View Holder --------------------------
    class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) = with(binding) {
            categoryNameTextView.text = category.name
        }
    }

    // ---------------------- Implemented Methods ----------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryViewHolder(
        ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // --------------------------- CallBack -----------------------------
    private class CategoryItemCallBack : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Category, newItem: Category) =
            oldItem == newItem
    }
}