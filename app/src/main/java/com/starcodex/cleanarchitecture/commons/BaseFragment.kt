package com.starcodex.cleanarchitecture.commons

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    fun enableHomeActionBar(enable: Boolean) = (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(enable)
    fun onBackPressed(): Boolean = false
}