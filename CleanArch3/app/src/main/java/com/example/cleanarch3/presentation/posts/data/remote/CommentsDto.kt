package com.example.cleanarch3.presentation.posts.data.remote

import com.example.cleanarch3.presentation.posts.domain.model.Comment
import com.google.gson.annotations.SerializedName

data class CommentsDto(
    val postId: Int,
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("body")
    val body: String
) {
    // Map the network DTO to the domain model
    fun toDomain(): Comment {
        return Comment(
            postId = postId,
            id = id,
            name = name,
            email = email,
            body = body
        )
    }
}
