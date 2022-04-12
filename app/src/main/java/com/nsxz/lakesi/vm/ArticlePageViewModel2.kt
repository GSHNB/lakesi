package com.nsxz.lakesi.vm

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nsxz.lakesi.model.Article
import com.nsxz.lakesi.repository.ArticleRepository
import com.nsxz.lakesi.repository.paging.ArticlePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ArticlePageViewModel2 @Inject constructor(app: Application,private val articleRepository: ArticleRepository) : BaseViewModel(app) {

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