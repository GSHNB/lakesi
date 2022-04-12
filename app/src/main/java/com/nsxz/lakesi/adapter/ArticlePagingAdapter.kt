package com.nsxz.lakesi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.nsxz.lakesi.databinding.ItemArticlePageBinding
import com.nsxz.lakesi.model.Article
import kotlinx.coroutines.CoroutineDispatcher

class ArticlePagingAdapter() : PagingDataAdapter<Article, BindingViewHolder<ItemArticlePageBinding>>(
    object :DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }
    }
) {
    override fun onBindViewHolder(
        holder: BindingViewHolder<ItemArticlePageBinding>,
        position: Int
    ) {

        val item=getItem(position)

        holder.binding.apply {
            article=item
            networkImage="http://img.aieat.com/upload/image/2a924226004n175439678t26.jpg"
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ItemArticlePageBinding> {
        return BindingViewHolder(ItemArticlePageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}