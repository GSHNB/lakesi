package com.nsxz.lakesi.net

import com.nsxz.lakesi.model.Article
import com.nsxz.lakesi.model.ArticleShell
import com.nsxz.lakesi.model.WanAndroidResp
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleApi {

    @GET("article/list/0/json")
    suspend fun searchArticles(
        @Query("author") key: String
    ): ArticleShell


    @GET("article/list/{pageNum}/json")
    suspend fun getKnowledgeArticles(
        @Path("pageNum") pageNum: Int,
        @Query("page_size") pageSize: Int,
        @Query("cid") cid: String = "60"
    ): WanAndroidResp


}