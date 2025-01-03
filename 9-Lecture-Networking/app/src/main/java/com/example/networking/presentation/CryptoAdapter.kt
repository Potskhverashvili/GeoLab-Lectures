package com.example.networking.presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.networking.data.CryptoData
import com.example.networking.databinding.ItemCryptoBinding

class CryptoAdapter : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    // ----------------------------------- Properties ----------------------------
    private var cryptoList = listOf<CryptoData>()

    // ------- update list ----------
    fun updateList(newList: List<CryptoData>) {
        cryptoList = newList
        notifyDataSetChanged()
    }

    // ----------------------------------- Inner Class CryptoViewHolder ----------------------------
    inner class CryptoViewHolder(private val binding: ItemCryptoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cryptoData: CryptoData) = with(binding) {
            rankTextView.text = cryptoData.rank.toString()
            titleTextView.text = "${cryptoData.name} - ${cryptoData.symbol}"
            statusTextView.text = if (cryptoData.isActive == true) "active" else "false"
            statusTextView.setTextColor(if (cryptoData.isActive == true) Color.GREEN else Color.RED)
        }
    }



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

    override fun getItemCount() = cryptoList.size

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(cryptoList[position])
    }
}