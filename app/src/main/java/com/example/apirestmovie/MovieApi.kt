package com.example.apirestmovie

import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("/3/movie/popular?api_key=08557c88e568621285b5b86365198c28&language=es-ES&page=1")
    fun allmovie() : Call<ListMovie>
}