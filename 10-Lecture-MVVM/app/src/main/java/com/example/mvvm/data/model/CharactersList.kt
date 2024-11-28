package com.example.mvvm.data

data class CharactersList(
    val results: List<CharacterItem>,
) {
    data class CharacterItem(
        val id: Int?,
        val name: String?,
        val status: String?,
        val image: String?,
    )
}

