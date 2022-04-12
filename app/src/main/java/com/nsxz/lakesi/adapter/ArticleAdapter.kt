package com.nsxz.lakesi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nsxz.lakesi.R
import com.nsxz.lakesi.databinding.ItemArticleBinding
import com.nsxz.lakesi.databinding.ItemUserBinding
import com.nsxz.lakesi.db.User
import com.nsxz.lakesi.model.Article

class ArticleAdapter: RecyclerView.Adapter<BindingViewHolder<ItemArticleBinding>>() {

    private val data= arrayListOf<Article>()

    fun setData(data:List<Article>?){
        this.data.clear()
        data?.let { this.data.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemArticleBinding> {
        return BindingViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemArticleBinding>, position: Int) {
        holder.binding.apply {
            val item=data[position]
            this.tvArticle.text="${item.title}"
        }
    }

    override fun getItemCount()=data.size
}