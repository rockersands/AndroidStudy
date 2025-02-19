package com.example.cleanarch3.presentation.posts.di

import com.example.cleanarch3.data.local.AppDatabase
import com.example.cleanarch3.presentation.posts.data.remote.PostApi
import com.example.cleanarch3.presentation.posts.data.repository.PostRepositoryImpl
import com.example.cleanarch3.presentation.posts.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostsModule {
    @Provides
    @Singleton
    fun providePostDao(db: AppDatabase) = db.postDao()

    // Provide Repository
    @Provides
    @Singleton
    fun providePostRepository(
        api: PostApi,
        db: AppDatabase
    ): PostRepository {
        return PostRepositoryImpl(api, db.postDao())
    }
}