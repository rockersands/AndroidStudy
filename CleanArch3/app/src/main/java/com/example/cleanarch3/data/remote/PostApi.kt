package com.example.cleanarch3.data.remote

import retrofit2.http.GET

interface PostApi {
    @GET("posts") // e.g. "https://jsonplaceholder.typicode.com/posts"
    suspend fun getPosts(): List<PostDto>
}
