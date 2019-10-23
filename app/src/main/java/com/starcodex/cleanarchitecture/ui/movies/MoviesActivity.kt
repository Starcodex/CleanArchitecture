package com.starcodex.cleanarchitecture.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListFragment
import com.starcodex.cleanarchitecture.utils.commons.BaseActivity

class MoviesActivity : BaseActivity(), FragmentActivityInteraction {
    override fun replaceFragmentCurrent(fragment: Fragment) {
        replaceFragment(fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(MoviesListFragment())
    }

}
