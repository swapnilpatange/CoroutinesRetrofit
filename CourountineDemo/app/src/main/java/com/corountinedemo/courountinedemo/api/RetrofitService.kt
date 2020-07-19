package com.corountinedemo.courountinedemo.api


import android.util.Log
import com.corountinedemo.courountinedemo.model.CommentModel
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {



    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiInterface {
            Log.e("retrofit","create")
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
    suspend fun loadComments():List<CommentModel>?{
        val retrofitCall  = create().getComments()
        if(retrofitCall.isSuccessful){
            return retrofitCall.body()

        }
        return null
    }

}