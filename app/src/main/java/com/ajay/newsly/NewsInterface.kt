package com.ajay.newsly

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=119cd1e8f0054e97bca373c917ab23dc
// https://newsapi.org/v2/everything?q=tesla&from=2024-05-17&sortBy=publishedAt&apiKey=119cd1e8f0054e97bca373c917ab23dc

const val BASE_URL = "https://newsapi.org/v2/"
const val API_KEY = "119cd1e8f0054e97bca373c917ab23dc"

interface NewsInterface {

    @GET("top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int) : Call<News>
}

object NewsService{
    val newsInstance: NewsInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
