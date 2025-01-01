package com.example.nestedscrollviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nestedscrollviewexample.data.Product
import com.example.nestedscrollviewexample.databinding.ItemCateoriesRvBinding
import com.example.nestedscrollviewexample.databinding.ItemFooterBinding
import com.example.nestedscrollviewexample.databinding.ItemProductBinding

class ProductsPageContentAdapter(
    private val products: List<Product>,
    private val categoryAdapter: CategoryAdapter
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // ------------------------ Categories View Holder -------------------------
    inner class CategoriesViewHolder(private val binding: ItemCateoriesRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.categoriesRecyclerView.adapter = categoryAdapter
        }
    }

    // ------------------------- Products View Holder ---------------------
    class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) = with(binding) {
            Glide.with(productImageView)
                .load(product.imageUrl)
                .into(productImageView)
            nameTextView.text = product.name
            descriptionTextView.text = product.description
            priceTextView.text = "${product.price}$"
        }
    }

    // -------------------------- Footer View Holder ----------------------
    class FooterViewHolder(binding: ItemFooterBinding) : RecyclerView.ViewHolder(binding.root)


    // ------------------------- Override Methods ------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {

            // --- Categories ---
            VIEW_TYPE_CATEGORIES -> {
                val binding = ItemCateoriesRvBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CategoriesViewHolder(binding)
            }

            // --- Products ---
            VIEW_TYPE_PRODUCT -> {
                val binding =
                    ItemProductBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                ProductViewHolder(binding)
            }

            // ---- Footer ----
            VIEW_TYPE_FOOTER -> {
                val binding = ItemFooterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false

                )
                FooterViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Wrong ViewType was found: $viewType")
        }
    }

    override fun getItemCount() = products.size + 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoriesViewHolder -> holder.bind()
            is ProductViewHolder -> holder.bind(products[position - 1])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_CATEGORIES
            products.size + 1 -> VIEW_TYPE_FOOTER
            else -> VIEW_TYPE_PRODUCT
        }
    }

    // ------------------- Companion Object ---------------------
    companion object {
        const val VIEW_TYPE_CATEGORIES = 0
        const val VIEW_TYPE_FOOTER = 1
        const val VIEW_TYPE_PRODUCT = 2

    }
}