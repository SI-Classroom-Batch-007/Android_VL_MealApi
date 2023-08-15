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
        getCategories()
    }

    val randomMeal = repository.randomMeal
    val categories = repository.categories
    val mealsByCategory = repository.mealsByCategory

    fun getRandomMeal() {
        viewModelScope.launch {
            repository.getRandomMeal()
        }
    }

    fun getMealsByCategory(category: String) {
        viewModelScope.launch {
            repository.getMealsByCategory(category)
        }
    }

    private fun getCategories() {
        viewModelScope.launch {
            repository.getCategories()
        }
    }



}