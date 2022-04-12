package com.nsxz.lakesi.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val instance by lazy {

        val interceptor=HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {

        })

        Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .baseUrl("https://wanandroid.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val articleApi by lazy {
        instance.create(ArticleApi::class.java)
    }

    fun <T> createApi(clazz: Class<T>):T{
        return instance.create(clazz)
    }
}