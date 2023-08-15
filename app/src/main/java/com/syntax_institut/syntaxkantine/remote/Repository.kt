package com.syntax_institut.syntaxkantine.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.syntaxkantine.remote.model.Category
import com.syntax_institut.syntaxkantine.remote.model.Meal
import java.lang.Exception

class Repository(private val api: MealApi) {

    private var _randomMeal = MutableLiveData<Meal>()
    val randomMeal: LiveData<Meal>
        get() = _randomMeal

    private var _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>>
        get() = _categories

    private var _mealsByCategory = MutableLiveData<List<Meal>>()
    val mealsByCategory: LiveData<List<Meal>>
        get() = _mealsByCategory

    suspend fun getRandomMeal() {
        try {
            val result = api.retrofitService.getRandomMeal()
            val meal = result.meals.first()
            _randomMeal.value = meal
        } catch (e: Exception) {
            Log.e("ERROR", "${e.message}")
        }
    }

    suspend fun getCategories() {
        try {
            val result = api.retrofitService.getCategories()
            val cats = result.categories
            _categories.value = filterCategories(cats)
        } catch (e: Exception) {
            Log.e("ERROR", "${e.message}")
        }
    }

    suspend fun getMealsByCategory(category: String) {
        try {
            val result = api.retrofitService.getMealsByCategory(category)
            _mealsByCategory.value = result.meals
        } catch (e: Exception) {
            Log.e("ERROR", "${e.message}")
        }
    }

    private fun filterCategories(categories: List<Category>): List<Category> {
        val returnCats: MutableList<Category> = mutableListOf()
        for (cat in categories) {
            if (cat.title != "Seafood") {
                returnCats.add(cat)
            }
        }
        return returnCats
    }

}