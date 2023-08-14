package com.syntax_institut.syntaxkantine.remote.model

import com.squareup.moshi.Json

data class Meal(
    @Json(name = "strMeal") val title: String,
    @Json(name = "strCategory") val category: String,
    @Json(name = "strMealThumb") val image: String
)