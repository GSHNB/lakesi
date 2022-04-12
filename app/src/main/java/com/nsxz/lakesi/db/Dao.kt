package com.nsxz.lakesi.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user:User)

    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

}

@Dao
interface ArticleDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articleList:List<ArticleEntity>)

    @Query("SELECT * FROM ArticleEntity")
    fun getArticles():PagingSource<Int,ArticleEntity>

    @Query("DELETE FROM ArticleEntity")
    suspend fun clearArticle()

}