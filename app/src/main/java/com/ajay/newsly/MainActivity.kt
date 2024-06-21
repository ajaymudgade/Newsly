package com.ajay.newsly

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var newsList: RecyclerView
    lateinit var newsAdapter1: newsAdapter
    private var articles = mutableListOf<Article>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsList = findViewById(R.id.newsList)

        getNews()

    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in", 1)
        news.enqueue(object: Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null){
                    Log.d("MYTAG", news.toString())
                    articles.addAll(news.articles)
                    newsAdapter1 = newsAdapter(this@MainActivity, articles)
                    newsList.adapter = newsAdapter1
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }

            }

            override fun onFailure(p0: Call<News>, p1: Throwable) {
                Log.d("MYTAG", "Failure")

            }
        })
    }
}