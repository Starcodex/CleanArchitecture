package com.starcodex.cleanarchitecture.ui.movies.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCase
import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCaseSource
import com.starcodex.cleanarchitecture.utils.commons.BaseViewModel
import javax.inject.Inject

class MoviesListViewModel @Inject constructor(private var moviesListUseCase: GetMoviesListUseCaseSource)
    :  BaseViewModel(),MoviesListContract.ViewModel {

    private val moviesListLiveData = MutableLiveData<List<MovieItem>>()

    override fun getMovieslistLiveData(): LiveData<List<MovieItem>> = moviesListLiveData

    override fun loadList(category: String) {
        compositeDisposable.addAll(moviesListUseCase.executeListLocal(category)!!.subscribe {
            moviesListLiveData.postValue(it)
        })
    }
}
