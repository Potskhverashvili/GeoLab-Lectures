package com.example.lecturedependency.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lecturedependency.domain.TestRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: TestRepository,
) : ViewModel() {

    fun getData() = viewModelScope.launch {
        repository.getSomeData()
    }

}