package com.starcodex.cleanarchitecture.commons

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.core.app.NavUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.starcodex.cleanarchitecture.R
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity: DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.framelayout)
    }


    override fun onBackPressed() {
        var handled = false
        val fragments = supportFragmentManager.fragments
        for (f in fragments) {
            if (f != null && f is BaseFragment)
                handled = f.onBackPressed()
            if (handled) break
        }
        if (!handled) super.onBackPressed()
    }

    protected fun addFragment(fragment: Fragment, @IdRes containerId: Int = R.id.fragmentContainer) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(containerId, fragment)
            .commit()
    }

    protected fun replaceFragment(fragment: Fragment,
                                  transactionName: String? = null,
                                  @IdRes containerId: Int = R.id.fragmentContainer) {

        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(containerId, fragment)
            .addToBackStack(transactionName)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                when {
                    (supportFragmentManager.backStackEntryCount > 0) -> onBackPressed()
                    (NavUtils.getParentActivityIntent(this) == null) -> onBackPressed()
                    else -> NavUtils.navigateUpFromSameTask(this)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}