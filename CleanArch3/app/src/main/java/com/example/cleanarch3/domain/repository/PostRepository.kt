package com.example.cleanarch3.domain.repository

import com.example.cleanarch3.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}