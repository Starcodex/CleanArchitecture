package com.starcodex.cleanarchitecture.utils.commons.adapter

import androidx.recyclerview.widget.DiffUtil

class ListAdapterItemsInvalidatorDiffCallback<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return false
    }
}