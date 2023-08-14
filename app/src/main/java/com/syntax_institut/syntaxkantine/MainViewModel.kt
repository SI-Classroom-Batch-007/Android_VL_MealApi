package com.syntax_institut.syntaxkantine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntax_institut.syntaxkantine.remote.MealApi
import com.syntax_institut.syntaxkantine.remote.Repository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = Repository(MealApi)

    init {
        getRandomMeal()
    }

    val randomMeal = repository.randomMeal

    fun getRandomMeal() {
        viewModelScope.launch {
            repository.getRandomMeal()
        }
    }

}