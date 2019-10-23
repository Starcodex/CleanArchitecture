package com.starcodex.cleanarchitecture.ui.movies.list.adapter

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.starcodex.cleanarchitecture.BuildConfig.*
import com.starcodex.cleanarchitecture.R
import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem

class MovieRowViewModel(var movie: MovieItem): ViewModel() {

    val title: String
        get() = movie!!.title!!

    val overview: String
        get() = movie!!.overview!!

    val imageUrl: String
        get() = "http://"+IMG_DOMAIN+IMG_300+ movie!!.poster_path!!


    object ImageBindingAdapter {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageUrl(view: ImageView, url: String) {
            Glide.with(view.getContext())
                .load(url)
                .placeholder(R.drawable.placeholder)
                .into(view)
        }
    }

}