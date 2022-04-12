package com.nsxz.lakesi.repository

import androidx.paging.*
import com.nsxz.lakesi.db.AppDatabase
import com.nsxz.lakesi.db.ArticleEntity
import com.nsxz.lakesi.model.Article
import com.nsxz.lakesi.model.mapper.Mapper
import com.nsxz.lakesi.net.ArticleApi
import com.nsxz.lakesi.net.ArticlesRemoteMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalPagingApi::class)
class ArticleRepository(
    private val api: ArticleApi,
    private val database: AppDatabase,
    private val mapper2ItemModel: Mapper<ArticleEntity, Article>
) {

    fun fetchArticleList(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = 8,
                prefetchDistance = 1,
                initialLoadSize = 16
            ),
            remoteMediator = ArticlesRemoteMediator(api, database)//请求网络数据放入数据库
        ) {
            database.articleDao().getArticles() //从数据库拿到数据
        }.flow.flowOn(Dispatchers.IO)
            .map { pagingdata ->
                pagingdata.map {
                    mapper2ItemModel.map(it)
                }
            }
    }
}


