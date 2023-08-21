package com.syntax_institut.syntaxkantine.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "meal_table")
data class Meal(

    @PrimaryKey
    @Json(name = "idMeal") val id: Int,

    @Json(name = "strMeal") val title: String,
    @Json(name = "strCategory") val category: String = "",
    @Json(name = "strMealThumb") val image: String,

)