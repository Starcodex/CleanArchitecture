package com.starcodex.cleanarchitecture.domain.movies.usecase

import com.nhaarman.mockitokotlin2.argumentCaptor
import com.starcodex.cleanarchitecture.data.movies.repository.LocalMoviesSource
import com.starcodex.cleanarchitecture.data.movies.repository.RemoteMoviesSource
import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.testutil.TestExecutionThreadsProvider
import com.starcodex.cleanarchitecture.utils.commons.ExecutionThreads
import io.reactivex.Maybe
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class GetMoviesListUseCaseTest {

    @Mock
    lateinit var onComplete: (it: List<MovieItem>) -> Unit

    @Mock
    lateinit var mockLocalMoviesSource: LocalMoviesSource

    @Mock
    lateinit var mockRemoteMoviesSource: RemoteMoviesSource

    lateinit var getMoviesListUseCase: GetMoviesListUseCase

    lateinit var mockExecutionThreads: ExecutionThreads

    val onCompleteCaptor = argumentCaptor<(it: List<MovieItem>) -> Unit>()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockExecutionThreads = TestExecutionThreadsProvider()
        getMoviesListUseCase = GetMoviesListUseCase(mockLocalMoviesSource,mockRemoteMoviesSource, mockExecutionThreads)

    }


    @Test
    fun `Retrieve Local List Empty`(){
        // --- When
        //`when`(mockRemoteMoviesSource.getRemoteMoviesList(anyString())).thenReturn(Observable.just(emptyList()))
        `when`(mockLocalMoviesSource.getLocalMoviesList(anyString())).thenReturn(Maybe.just(emptyList()))

        // --- Execute
        getMoviesListUseCase.executeListLocal(anyString(),onComplete)

        // --- Then
        verify(onComplete)(emptyList())
    }
}