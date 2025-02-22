package com.example.cleanarch3.presentation.posts.data.repository

import com.example.cleanarch3.presentation.posts.data.local.PostDao
import com.example.cleanarch3.presentation.posts.data.local.PostEntity
import com.example.cleanarch3.presentation.posts.data.remote.PostApi
import com.example.cleanarch3.presentation.posts.domain.model.Comment
import com.example.cleanarch3.presentation.posts.domain.model.Post
import com.example.cleanarch3.presentation.posts.domain.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi,
    private val dao: PostDao
) : PostRepository {

    override suspend fun getPosts(): List<Post> = withContext(Dispatchers.IO) {
        // 1. Fetch from network
        val remotePosts = api.getPosts()
        println("Fetched ${remotePosts.size} posts from API")

        // 2. Save to DB
        dao.insertPosts(remotePosts.map { PostEntity(it.id, it.title, it.body) })
        println("Inserted posts into DB")

        // 3. Collect Flow from DB (first() to get the first emitted value)
        val localPosts = dao.getAllPosts()
        println("Fetched ${localPosts.size} posts from DB")

        return@withContext localPosts.map { it.toDomain() }
    }

    override suspend fun getComments(): List<Comment> {
        TODO("Not yet implemented")
    }
}