package com.nsxz.lakesi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nsxz.lakesi.R
import com.nsxz.lakesi.databinding.ItemUserBinding
import com.nsxz.lakesi.db.User

class UserAdapter: RecyclerView.Adapter<BindingViewHolder<ItemUserBinding>>() {

    private val data= arrayListOf<User>()

    fun setData(data:List<User>?){
        this.data.clear()
        data?.let { this.data.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemUserBinding> {
        return BindingViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemUserBinding>, position: Int) {
        holder.binding.apply {
            val item=data[position]
            this.tvUser.text="${item.uid},${item.firstName},${item.lastName}"
        }
    }

    override fun getItemCount()=data.size
}