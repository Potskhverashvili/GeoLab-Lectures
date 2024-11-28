package com.example.networking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.networking.databinding.ItemCryptoBinding

class CryptoAdapter : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {


    inner class CryptoViewHolder(private val binding: ItemCryptoBinding) :
        RecyclerView.ViewHolder(binding.root)

    // ----------------------------------- Override Methods ----------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        return CryptoViewHolder(
            ItemCryptoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}