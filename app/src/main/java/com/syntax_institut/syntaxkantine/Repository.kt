package com.syntax_institut.syntaxkantine

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.syntaxkantine.local.MealDatabase
import com.syntax_institut.syntaxkantine.model.Category
import com.syntax_institut.syntaxkantine.model.Meal
import com.syntax_institut.syntaxkantine.remote.MealApi
import java.lang.Exception

class Repository(private val api: MealApi, private val database: MealDatabase) {

    private var _randomMeal = MutableLiveData<Meal>()
    val randomMeal: LiveData<Meal>
        get() = _randomMeal

    private var _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>>
        get() = _categories

    private var _mealsByCategory = MutableLiveData<List<Meal>>()
    val mealsByCategory: LiveData<List<Meal>>
        get() = _mealsByCategory

    private var _favouriteMeals = MutableLiveData<List<Meal>>()
    val favouriteMeals: LiveData<List<Meal>>
        get() = _favouriteMeals

    suspend fun getRandomMeal() {
        try {
            val result = MealApi.retrofitService.getRandomMeal()
            val meal = result.meals.first()
            _randomMeal.value = meal
        } catch (e: Exception) {
            Log.e("ERROR", "${e.message}")
        }
    }

    suspend fun getCategories() {
        try {
            val result = MealApi.retrofitService.getCategories()
            val cats = result.categories
            _categories.value = filterCategories(cats)
        } catch (e: Exception) {
            Log.e("ERROR", "${e.message}")
        }
    }

    suspend fun getMealsByCategory(category: String) {
        try {
            val result = MealApi.retrofitService.getMealsByCategory(category)
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

    suspend fun insertCurrentMeal() {
        try {
            database.mealDao.insertMeal(_randomMeal.value!!)
        } catch (e: Exception) {
            Log.e("ERROR", "${e.message}")
        }
    }

    suspend fun loadAllMeals() {
        try {
            val allMeals = database.mealDao.getAllMeals()
            _favouriteMeals.value = allMeals
        } catch (e: Exception) {
            Log.e("ERROR", "${e.message}")
        }
    }

}