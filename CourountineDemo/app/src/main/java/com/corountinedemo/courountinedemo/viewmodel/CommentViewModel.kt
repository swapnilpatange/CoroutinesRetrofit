package com.corountinedemo.courountinedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.corountinedemo.courountinedemo.api.CommentRepository
import kotlinx.coroutines.Dispatchers

class CommentViewModel : ViewModel() {

    private val commentRepository = CommentRepository()

    fun loadComments() = liveData(Dispatchers.IO) {
        val data=commentRepository.loadComments()
        emit(data)
    }
}