package com.example.apirestmovie

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.themoviedb.org"

class RetrofitClient {
    companion object{
        fun retrofitInstance(): MovieApi{
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return  retrofit.create(MovieApi::class.java)
        }
    }
}