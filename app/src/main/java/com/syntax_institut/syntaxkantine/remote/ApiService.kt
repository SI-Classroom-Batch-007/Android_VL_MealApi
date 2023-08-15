package com.syntax_institut.syntaxkantine.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.syntax_institut.syntaxkantine.remote.model.CategoryResult
import com.syntax_institut.syntaxkantine.remote.model.MealResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://themealdb.com/api/json/v1/1/"

private val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("random.php")
    suspend fun getRandomMeal(): MealResult

    @GET("categories.php")
    suspend fun getCategories(): CategoryResult

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): MealResult

}

object MealApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

// https://themealdb.com/api/json/v1/1/filter.php?c=Lamb