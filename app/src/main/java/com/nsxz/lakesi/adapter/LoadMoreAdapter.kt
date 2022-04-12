package com.nsxz.lakesi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.nsxz.lakesi.databinding.PagingLoadmoreBinding

class LoadMoreAdapter: LoadStateAdapter<BindingViewHolder<PagingLoadmoreBinding>>() {
    override fun onBindViewHolder(
        holder: BindingViewHolder<PagingLoadmoreBinding>,
        loadState: LoadState
    ) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): BindingViewHolder<PagingLoadmoreBinding> {
        return BindingViewHolder(PagingLoadmoreBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}