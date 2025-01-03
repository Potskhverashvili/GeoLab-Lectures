package com.example.networking.presentation

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.networking.data.CryptoApi
import com.example.networking.data.createRetrofit
import com.example.networking.databinding.ActivityCryptoBinding
import kotlinx.coroutines.launch

class CryptoActivity : AppCompatActivity() {


    // ----------------------------------- Properties ----------------------------
    private val cryptoAdapter = CryptoAdapter()
    private val binding by lazy { ActivityCryptoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        setContentView(binding.root)
        getDataFromNetwork()
    }

    // ------- adapter to recycler view ----------
    private fun initViews() {
        binding.cryptoRecyclerView.adapter = cryptoAdapter
    }




    // ------- Get data from network ----------
    private fun getDataFromNetwork() {
        val cryptoApi = createRetrofit().create(CryptoApi::class.java)

        lifecycleScope.launch {
            val cryptoList = cryptoApi.getCryptoList().body()
            d("MyLog", " List: " + cryptoList.toString())



            cryptoAdapter.updateList(cryptoList ?: emptyList())
        }
    }
}