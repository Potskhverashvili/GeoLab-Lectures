package com.example.coctailsapplication.presentation.screens.drinks_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailsapplication.domain.model.DrinksList
import com.example.coctailsapplication.domain.repository.DrinksRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DrinksListViewModel(
    private val drinkRepository: DrinksRepository,
) : ViewModel() {

    val drinksFlow = MutableStateFlow(emptyList<DrinksList.Drink>())
    val errorFlow = MutableSharedFlow<Throwable>()

    init {
        getDrinks()
    }

    private fun getDrinks(drinkName: String = "margarita") = viewModelScope.launch {
        drinkRepository.getDrinks(drinkName)
            .onSuccess {
                drinksFlow.emit(it.drinks ?: emptyList())
            }
            .onFailure {
                errorFlow.emit(it)
            }
    }

}