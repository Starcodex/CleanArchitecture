package com.starcodex.cleanarchitecture.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.nhaarman.mockito_kotlin.mock
import com.starcodex.cleanarchitecture.data.movies.repository.LocalMoviesSource
import com.starcodex.cleanarchitecture.data.movies.repository.RemoteMoviesSource
import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCase
import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCaseSource
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListViewModel
import com.starcodex.cleanarchitecture.utils.commons.ExecutionThreads
import io.reactivex.Maybe
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.MockitoAnnotations


@SmallTest
class GetMoviesListUseCaseTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    val getLocalMoviesSource: LocalMoviesSource = mock()

    val getRemoteMoviesSource : RemoteMoviesSource = mock()

    val executionThreads: ExecutionThreads = mock()

    val getMoviesListUseCase by lazy { GetMoviesListUseCase(getLocalMoviesSource,getRemoteMoviesSource,executionThreads) }


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun test_MovieListUseCase_getMoviesList_Completed(){
        val response = Throwable("Error response")
        `when`(getLocalMoviesSource.getLocalMoviesList(anyString()))
            .thenReturn(Maybe.just(emptyList()))

        getMoviesListUseCase.executeListLocal("popular")!!
            .test()
            .assertError(response)

    }
}