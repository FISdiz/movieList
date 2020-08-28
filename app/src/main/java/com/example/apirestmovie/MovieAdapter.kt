package com.example.apirestmovie

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private var movieDataset: MutableList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Log.d("Adapter", "${movieDataset.get(position)}")
        holder.textTitle.text = movieDataset.get(position).original_title
        holder.textSinopsis.text = movieDataset.get(position).overview

        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+movieDataset.get(position).poster_path).into(holder.imageMovie);
    }

    override fun getItemCount(): Int {
        return movieDataset.size
    }

    fun updateItems(it: List<Movie>) {
        movieDataset.clear()
        movieDataset.addAll(it)
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTitle = itemView.textViewTitle
        var imageMovie = itemView.imageViewPoster
        var textSinopsis = itemView.textViewSinopsis
    }
}