package com.nsxz.lakesi.di

import android.app.Application
import androidx.room.Room
import com.nsxz.lakesi.db.AppDatabase
import com.nsxz.lakesi.db.ArticleDao
import com.nsxz.lakesi.db.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDataBase(app: Application): AppDatabase {
        return Room.databaseBuilder(app,AppDatabase::class.java,"user.db").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: AppDatabase):UserDao{
        return database.userDao()
    }


    @Singleton
    @Provides
    fun provideArticleDao(database: AppDatabase):ArticleDao{
        return database.articleDao()
    }

}