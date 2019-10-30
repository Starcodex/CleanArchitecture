package com.starcodex.cleanarchitecture.ui.movies.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.starcodex.cleanarchitecture.commons.BaseFragment
import com.starcodex.cleanarchitecture.databinding.MovieDetailBinding
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.ui.movies.list.adapter.MovieRowViewModel

class DetailMovieFragment(var movieItem: MovieItem) : BaseFragment(){

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
        enableHomeActionBar(true)
        binding.movieViewModel = MovieRowViewModel(movieItem)
    }
}