package com.example.cleanarch3.di

import android.content.Context
import androidx.room.Room
import com.example.cleanarch3.data.local.AppDatabase
import com.example.cleanarch3.data.remote.PostApi
import com.example.cleanarch3.data.repository.PostRepositoryImpl
import com.example.cleanarch3.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    // Provide Retrofit
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // Example public API
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    // Provide Room Database
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        ).build()
    }

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