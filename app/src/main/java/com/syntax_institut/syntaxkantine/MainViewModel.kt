package com.syntax_institut.syntaxkantine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntax_institut.syntaxkantine.local.MealDatabase
import com.syntax_institut.syntaxkantine.remote.MealApi
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = Repository(MealApi, MealDatabase.getDatabase(application))

    init {
        getRandomMeal()
        getCategories()
    }

    val randomMeal = repository.randomMeal
    val categories = repository.categories
    val mealsByCategory = repository.mealsByCategory
    val favouriteMeals = repository.favouriteMeals

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

    fun saveCurrentMeal() {
        viewModelScope.launch {
            repository.insertCurrentMeal()
        }
    }

    fun loadAllMeals() {
        viewModelScope.launch {
            repository.loadAllMeals()
        }
    }

    private fun getCategories() {
        viewModelScope.launch {
            repository.getCategories()
        }
    }





}