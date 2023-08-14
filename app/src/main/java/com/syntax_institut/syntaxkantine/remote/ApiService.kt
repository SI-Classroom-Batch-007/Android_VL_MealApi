package com.syntax_institut.syntaxkantine.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.syntax_institut.syntaxkantine.remote.model.MealResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

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

}

object MealApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}