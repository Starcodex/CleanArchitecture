package com.starcodex.cleanarchitecture.ui.movies.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.starcodex.cleanarchitecture.databinding.MovieDetailBinding
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.ui.movies.list.adapter.MovieRowViewModel
import com.starcodex.cleanarchitecture.commons.BaseFragment

class DetailMovieFragment(var movieItem: MovieItem) : BaseFragment(){

    companion object {
        fun newInstance(movieItem : MovieItem) = DetailMovieFragment(movieItem)
    }


    lateinit var binding: MovieDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.movieViewModel = MovieRowViewModel(movieItem)
    }
}