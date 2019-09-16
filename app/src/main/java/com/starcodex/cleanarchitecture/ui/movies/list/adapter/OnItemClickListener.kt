package com.starcodex.cleanarchitecture.ui.movies.list.adapter

import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem

interface OnItemClickListener {
    fun onItemClick(item: MovieItem)
}