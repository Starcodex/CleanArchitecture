package com.starcodex.cleanarchitecture.data.movies.repository

import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.CategoriesMoviesDao
import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.CategoryDao
import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.MovieDao
import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.MovieEntity
import com.starcodex.cleanarchitecture.data.movies.datasorce.remote.MoviesListApiClient
import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem
import io.reactivex.Maybe
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.MockitoAnnotations

class MoviesRepositoryTest {

    @Mock
    lateinit var mockMoviesListApiClient: MoviesListApiClient

    @Mock
    lateinit var mockMoviesLocalDao: MovieDao

    @Mock
    lateinit var mockCategoriesMoviesDao : CategoriesMoviesDao

    @Mock
    lateinit var mockCategoryDao : CategoryDao

    lateinit var moviesRepository: MoviesRepository

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        moviesRepository = MoviesRepository(mockMoviesListApiClient,mockMoviesLocalDao,mockCategoriesMoviesDao,mockCategoryDao)
    }

    @Test
    fun `Get local list empty`(){
        // --- Given
        val testObserver = TestObserver<List<MovieEntity>>()

        // --- When
        `when`(mockCategoriesMoviesDao.getMoviesByCategory(anyString())).thenReturn(Maybe.just(emptyList()))

        // --- Execute
        val test = moviesRepository.getLocalMoviesList("popular")

        // --- Then
        test.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(emptyList())
        val listResult = testObserver.values()[0]
        assertThat(listResult.size, `is`(0))
    }
}