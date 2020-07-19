package com.corountinedemo.courountinedemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.corountinedemo.courountinedemo.R
import com.corountinedemo.courountinedemo.model.CommentModel
import kotlinx.android.synthetic.main.comment_item.view.*

class CommentAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var commentModels: List<CommentModel>? = null
    override fun getItemCount(): Int {
        return commentModels?.run {
            size
        } ?: let {
            0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, null)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is CommentViewHolder) {
            holder.bind(commentModels!![position])
        }
    }


    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(commentModel: CommentModel?) {

            itemView.txtname.text = commentModel?.name
            itemView.txtemail.text = commentModel?.email
        }
    }
}