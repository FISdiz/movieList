package com.example.apirestmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var movieList = ArrayList<Movie>()
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MovieAdapter(movieList)
        movieRecycler.adapter = adapter

        loadApiData()

    }

    private fun loadApiData(){
        val call = RetrofitClient.retrofitInstance().allmovie()
        //val call = service.allmovie()

        call.enqueue(object : Callback<ListMovie>{
            override fun onResponse(call: Call<ListMovie>, response: Response<ListMovie>) {
                Log.d("Adapter", "${response.code() }")
                Log.d("Adapter", "${call.request().url() }")
                    adapter.updateItems(response.body()!!.results )
            }

            override fun onFailure(call: Call<ListMovie>, t: Throwable) {
                Log.d("Adapter", "Error al cargar peliculas $t")
            }
        })
    }
}