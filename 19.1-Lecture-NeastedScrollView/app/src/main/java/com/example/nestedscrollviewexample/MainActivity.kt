package com.example.nestedscrollviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nestedscrollviewexample.adapter.CategoryAdapter
import com.example.nestedscrollviewexample.adapter.ProductsPageContentAdapter
import com.example.nestedscrollviewexample.data.Category
import com.example.nestedscrollviewexample.data.Product
import com.example.nestedscrollviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val categoriesList = (listOf(
        "All",
        "Woman",
        "Man",
        "All",
        "Woman",
        "Man",
        "All",
        "Woman",
        "Man"
    )).map { Category(name = it) }

    private val productsContentAdapter = ProductsPageContentAdapter(
        products = Product.generateList(),
        categoryAdapter = CategoryAdapter().apply {
            submitList(categoriesList)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = productsContentAdapter
    }
}