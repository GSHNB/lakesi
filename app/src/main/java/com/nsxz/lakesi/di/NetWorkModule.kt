package com.nsxz.lakesi.di

import android.util.Log
import com.nsxz.lakesi.init.SERVER_URL
import com.nsxz.lakesi.net.ArticleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetWorkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor=HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.d("myapp",  it)
        })
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provoideArticleApi(retrofit: Retrofit):ArticleApi{
        return retrofit.create(ArticleApi::class.java)
    }


}