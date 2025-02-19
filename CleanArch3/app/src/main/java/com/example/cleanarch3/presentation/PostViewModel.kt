    package com.example.cleanarch3.presentation

    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.example.cleanarch3.domain.model.Post
    import com.example.cleanarch3.domain.usecase.GetPostsUseCase
    import dagger.hilt.android.lifecycle.HiltViewModel
    import kotlinx.coroutines.flow.MutableStateFlow
    import kotlinx.coroutines.flow.asStateFlow
    import kotlinx.coroutines.launch
    import javax.inject.Inject

    @HiltViewModel
    class PostViewModel @Inject constructor(
        private val getPostsUseCase: GetPostsUseCase
    ) : ViewModel() {

        private val _postsState = MutableStateFlow<List<Post>>(emptyList())
        val postsState = _postsState.asStateFlow()

        fun loadPosts() {
            viewModelScope.launch {
                try {
                    val posts = getPostsUseCase()
                    _postsState.value = posts
                } catch (e: Exception) {
                    // handle error
                }
            }
        }
    }