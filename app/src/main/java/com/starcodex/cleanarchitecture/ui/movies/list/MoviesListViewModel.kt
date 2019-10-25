package com.starcodex.cleanarchitecture.ui.movies.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCase
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.commons.BaseViewModel
import javax.inject.Inject

class MoviesListViewModel @Inject constructor(private var moviesListUseCase: GetMoviesListUseCase)
    :  BaseViewModel(),MoviesListContract.ViewModel {


    private val moviesListLiveData = MutableLiveData<List<MovieItem>>()

    private fun setMovieslistLiveDataValue(playlist: List<MovieItem>) {
        moviesListLiveData.value = playlist
    }

    override fun getMovieslistLiveData(): LiveData<List<MovieItem>> = moviesListLiveData

    override fun loadList(category: String) {
        compositeDisposable.addAll(moviesListUseCase.executeListLocal(category) {
            setMovieslistLiveDataValue(it)
        })
    }
}
