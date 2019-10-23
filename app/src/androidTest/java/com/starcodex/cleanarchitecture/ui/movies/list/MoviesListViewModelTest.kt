package com.starcodex.cleanarchitecture.ui.movies.list

import android.os.Bundle
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.starcodex.cleanarchitecture.R
import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCase
import com.starcodex.cleanarchitecture.espressoDaggerMockRule
import com.starcodex.cleanarchitecture.ui.movies.MoviesActivity
import com.starcodex.cleanarchitecture.utils.commons.ExecutionThreads
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import it.cosenonjaviste.daggermock.InjectFromComponent
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCaseSource
import org.mockito.Mockito.`when`
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable


@SmallTest
class MoviesListViewModelTest {

    @Rule
    @JvmField
    val testRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var rule = espressoDaggerMockRule()

    val view: MoviesListFragment = mock()


    @Mock
    private var mockGetMoviesListUseCase: GetMoviesListUseCaseSource = mock()


    private lateinit var viewModel: MoviesListViewModel


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesListViewModel(mockGetMoviesListUseCase)
    }

    @Test
    fun testFetchMoviesList(){
        `when`(viewModel.getMovieslistLiveData())
    }


}