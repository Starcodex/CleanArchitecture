package com.starcodex.cleanarchitecture.ui.movies.list

import androidx.lifecycle.MutableLiveData
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem

interface MoviesListViewModel {
    val moviesListLiveData : MutableLiveData<List<MovieItem>>
    fun loadList(category: String)
}