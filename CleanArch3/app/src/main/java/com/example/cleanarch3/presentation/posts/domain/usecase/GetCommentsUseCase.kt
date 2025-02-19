package com.example.cleanarch3.presentation.posts.domain.usecase

import com.example.cleanarch3.presentation.posts.domain.model.Comment
import com.example.cleanarch3.presentation.posts.domain.model.Post
import com.example.cleanarch3.presentation.posts.domain.repository.PostRepository
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(): List<Comment> {
        // Add business logic if needed (e.g., filtering, error handling)
        return repository.getComments()
    }
}