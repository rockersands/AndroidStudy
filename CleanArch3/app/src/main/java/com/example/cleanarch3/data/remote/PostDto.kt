package com.example.cleanarch3.data.remote

import com.example.cleanarch3.domain.model.Post
import com.google.gson.annotations.SerializedName

data class PostDto(
    val id: Int,
    val title: String,
    @SerializedName("body")
    val body: String
) {
    // Map the network DTO to the domain model
    fun toDomain(): Post {
        return Post(
            id = id,
            title = title,
            body = body
        )
    }
}
