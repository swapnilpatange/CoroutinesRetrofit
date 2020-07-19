package com.corountinedemo.courountinedemo.api


import com.corountinedemo.courountinedemo.model.CommentModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("comments")
    suspend fun getComments(): Response<List<CommentModel>>
}