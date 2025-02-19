package com.example.cleanarch3.presentation.posts.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarch3.presentation.posts.domain.model.Post

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val body: String
) {
    fun toDomain(): Post {
        return Post(id, title, body)
    }

    companion object {
        fun fromDomain(post: Post) = PostEntity(
            id = post.id,
            title = post.title,
            body = post.body
        )
    }
}