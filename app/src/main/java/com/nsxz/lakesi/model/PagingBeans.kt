package com.nsxz.lakesi.model

data class WanAndroidResp(
    val `data`: Data,
    val errorCode: Int,
    val errorMsg: String
)

data class Data(
    val curPage: Int,
    val datas: List<Article>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
){
    fun hasMore():Boolean{
        return curPage<pageCount
    }
}

data class Article(
    val apkLink: String="",
    val audit: Int=0,
    val author: String="",
    val canEdit: Boolean=false,
    val desc: String="",
    val descMd: String="",
    val id: Int=0,
    val title: String="",
    val type: Int=0,
    val userId: Int=0,
)