package com.starcodex.cleanarchitecture.ui.movies.list

import androidx.lifecycle.MutableLiveData
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.commons.BaseViewModel
import com.starcodex.cleanarchitexture.domain.movies.usecase.GetMoviesListUseCase
import javax.inject.Inject

class MoviesListViewModelImpl @Inject constructor(private var moviesListUseCase: GetMoviesListUseCase)
    :  BaseViewModel(), MoviesListViewModel {

    override val moviesListLiveData = MutableLiveData<List<MovieItem>>()


    override fun loadList(category: String) {
        compositeDisposable.addAll(moviesListUseCase.getMoviesList(category).subscribe {
            moviesListLiveData.postValue(it)
        })
    }
}
