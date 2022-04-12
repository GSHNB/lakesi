package com.nsxz.lakesi.adapter

import android.graphics.Color
import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

class ImageViewBindingAdapter {

    companion object{
        @JvmStatic
        @BindingAdapter("image")//databinding 要求是静态方法
        fun setImage(imageView:ImageView,url:String){
            if (url.isNotBlank()){
                imageView.load(url)
            }else{
                imageView.setBackgroundColor(Color.GRAY)
            }
        }
    }
}