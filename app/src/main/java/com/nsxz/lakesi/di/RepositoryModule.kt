package com.nsxz.lakesi.di

import com.nsxz.lakesi.db.AppDatabase
import com.nsxz.lakesi.model.mapper.Entity2ItemModelMapper
import com.nsxz.lakesi.net.ArticleApi
import com.nsxz.lakesi.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMapper():Entity2ItemModelMapper{
        return Entity2ItemModelMapper()
    }

    @Singleton
    @Provides
    fun provideArticleRepository(
        api: ArticleApi,
        database: AppDatabase,
        mapper: Entity2ItemModelMapper
    ):ArticleRepository{
        return ArticleRepository(api, database, mapper)
    }


}