package com.nsxz.lakesi.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nsxz.lakesi.model.Article
import com.nsxz.lakesi.net.RetrofitClient
import kotlinx.coroutines.delay

class ArticlePagingSource : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
//        delay(2000)
        val currentPage = params.key ?: 0
        val pageSize = params.loadSize
        val data = RetrofitClient.articleApi.getKnowledgeArticles(currentPage, pageSize)

        var prevKey: Int? = null
        var nextKey: Int? = null

        val realPageSize = 8
        val initialLoadSize = 16
        if (currentPage == 0) {
            prevKey = null
            nextKey = if (data.data.hasMore()) initialLoadSize / realPageSize else null
        } else {
            prevKey = currentPage - 1
            nextKey = if (data.data.hasMore()) currentPage + 1 else null
        }

        return try {
            LoadResult.Page(
                data = data.data.datas,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition
    }
}