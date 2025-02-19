package com.example.cleanarch3.presentation.posts.data.remote

import retrofit2.http.GET

interface PostApi {
    @GET("posts") // e.g. "https://jsonplaceholder.typicode.com/posts"
    suspend fun getPosts(): List<PostDto>

    @GET("comments") // e.g. "https://jsonplaceholder.typicode.com/comments"
    suspend fun getComments(): List<CommentsDto>
}
