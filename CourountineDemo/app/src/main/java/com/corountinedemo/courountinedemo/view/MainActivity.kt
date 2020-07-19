package com.corountinedemo.courountinedemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.corountinedemo.courountinedemo.viewmodel.CommentViewModel
import com.corountinedemo.courountinedemo.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val commentViewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)
        commentViewModel.loadComments().observe(this, Observer { t ->

            commentList.apply {
                adapter = CommentAdapter().apply {
                    commentModels = t
                }
                layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            }

        })
        GlobalScope.launch(Dispatchers.IO) {
            val text = getText()
            withContext(Dispatchers.Main) {
                txtname.text = text
            }
        }

    }

    suspend fun getText(): String {
        delay(1000)
        return "My text"
    }
}
