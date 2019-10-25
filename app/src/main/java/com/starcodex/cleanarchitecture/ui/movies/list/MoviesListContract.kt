package com.starcodex.cleanarchitecture.ui.movies.list

import androidx.lifecycle.LiveData
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem

interface MoviesListContract {
    interface View
    interface ViewModel {
        fun getMovieslistLiveData(): LiveData<List<MovieItem>>
        fun loadList(category: String)
    }
}