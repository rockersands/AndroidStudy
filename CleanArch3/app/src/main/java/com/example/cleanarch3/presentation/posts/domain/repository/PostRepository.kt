package com.example.cleanarch3.presentation.posts.domain.repository

import com.example.cleanarch3.presentation.posts.domain.model.Comment
import com.example.cleanarch3.presentation.posts.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getComments(): List<Comment>
}