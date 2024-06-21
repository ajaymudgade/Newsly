package com.ajay.newsly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class newsAdapter (val context: Context, val articleList: List<Article>) : RecyclerView.Adapter<newsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.newsTitle.text = articleList[position].title
        holder.newsDescription.text = articleList[position].description
        Glide.with(context).load(articleList[position].urlToImage).into(holder.newsImage)
    }


    override fun getItemCount(): Int {
        return articleList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        var newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
        var newsDescription: TextView = itemView.findViewById(R.id.newsDescription)
    }

}