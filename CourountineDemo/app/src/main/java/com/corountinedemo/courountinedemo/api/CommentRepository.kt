package com.corountinedemo.courountinedemo.api

class CommentRepository {

    val retrofitService= RetrofitService()
    suspend fun loadComments()=retrofitService.loadComments()
}