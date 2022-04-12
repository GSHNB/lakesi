package com.nsxz.lakesi.model

//data class Article(val id:Int,val title:String,val author :String)

data class Articles(val datas:List<Article>)

data class ArticleShell(val data:Articles)
