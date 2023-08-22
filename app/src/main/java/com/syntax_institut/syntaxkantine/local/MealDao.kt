package com.syntax_institut.syntaxkantine.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.syntax_institut.syntaxkantine.model.Meal

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meal: Meal)

//    @Query("SELECT * FROM meal_table")
//    suspend fun getAllMeals(): List<Meal>

    @Query("SELECT * FROM meal_table")
    fun getAllMealsLive(): LiveData<List<Meal>>

    @Delete
    suspend fun deleteMeal(meal: Meal)
}