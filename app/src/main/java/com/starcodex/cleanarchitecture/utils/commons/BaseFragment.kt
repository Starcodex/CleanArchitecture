package com.starcodex.cleanarchitecture.utils.commons

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class BaseFragment<B: ViewDataBinding, VM: ViewModel>: Fragment() {

    protected lateinit var binding: B
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    fun onBackPressed(): Boolean = false

}