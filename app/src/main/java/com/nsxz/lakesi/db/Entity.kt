package com.nsxz.lakesi.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid:Int,
    @ColumnInfo(name = "first_name") val firstName:String,
    @ColumnInfo(name = "last_name") val lastName:String
)

@Entity
data class ArticleEntity(
    @PrimaryKey val id:Int,
    val title:String,
    val author:String
)

