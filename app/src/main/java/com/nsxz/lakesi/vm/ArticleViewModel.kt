package com.nsxz.lakesi.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nsxz.lakesi.LOG_TAG
import com.nsxz.lakesi.model.Article
import com.nsxz.lakesi.net.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ArticleViewModel(app:Application):BaseViewModel(app) {


    val articles=MutableLiveData<List<Article>>()

    fun searchArticles(key:String){
        viewModelScope.launch {
            flow{
                val list=RetrofitClient.articleApi.searchArticles(key)
                Log.d(LOG_TAG, list.toString())
                emit(list)
            }.flowOn(Dispatchers.IO).catch {
                it.printStackTrace()
            }.collect { articles.value=it.data.datas }
        }
    }

}