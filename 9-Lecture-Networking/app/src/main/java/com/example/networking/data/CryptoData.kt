package com.example.networking.data

import com.google.gson.annotations.SerializedName


data class CryptoData(
    val id: String? = null,
    val name: String? = null,
    val symbol: String? = null,
    val rank: Int?,

    @SerializedName("is_name")
    val isNew: Boolean?,

    @SerializedName("is_active")
    val isActive: Boolean?,
    val type: String?,
)