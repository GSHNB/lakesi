package com.nsxz.lakesi.net

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.nsxz.lakesi.db.AppDatabase
import com.nsxz.lakesi.db.ArticleEntity
import com.nsxz.lakesi.model.Article

@OptIn(ExperimentalPagingApi::class)
class ArticlesRemoteMediator(private val api: ArticleApi, private val database: AppDatabase): RemoteMediator<Int, ArticleEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ArticleEntity>
    ): MediatorResult {

        //判断loadtype

        //请求网络分页数据

        //插入数据库

        TODO("")

    }
}