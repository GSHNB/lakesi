package com.nsxz.lakesi.vm

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nsxz.lakesi.model.Article
import com.nsxz.lakesi.repository.paging.ArticlePagingSource
import kotlinx.coroutines.flow.Flow

class ArticlePageViewModel(app: Application) : BaseViewModel(app) {

    //将flow保存在viewmodel的属性上面，避免配置改变时重新加载，需要调用cachedIn方法
    private val article by lazy {
        Pager(
            config = PagingConfig(
                pageSize = 8,
                initialLoadSize = 16
            ),
            pagingSourceFactory = { ArticlePagingSource() }
        ).flow.cachedIn(viewModelScope)
    }

    fun loadArticle() : Flow<PagingData<Article>>{
         return article
    }
}