package com.syntax_institut.syntaxkantine.remote.model

import com.squareup.moshi.Json

data class Category(
    @Json(name = "strCategory") val title: String,
    @Json(name = "strCategoryThumb") val image: String
)