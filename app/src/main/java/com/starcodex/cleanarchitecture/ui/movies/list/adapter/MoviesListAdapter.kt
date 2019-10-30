package com.starcodex.cleanarchitecture.ui.movies.list.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.starcodex.cleanarchitecture.R
import com.starcodex.cleanarchitecture.databinding.MovieRowBinding
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.commons.adapter.BindableViewHolder
import com.starcodex.cleanarchitecture.commons.adapter.ListAdapterItemsInvalidatorDiffCallback

class MoviesListAdapter(private var context: Context, private var listener: OnItemClickListener)
    : ListAdapter<MovieItem,
        BindableViewHolder<MovieRowBinding>>
    (ListAdapterItemsInvalidatorDiffCallback<MovieItem>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder<MovieRowBinding> {
        return BindableViewHolder(context, parent, R.layout.movie_row)
    }

    override fun onBindViewHolder(holder: BindableViewHolder<MovieRowBinding>, position: Int) {
        holder.binding.movieViewModel = MovieRowViewModel(getItem(position))
        holder.binding.rowContent.setOnClickListener { listener.onItemClick(getItem(position)) }
    }

}
