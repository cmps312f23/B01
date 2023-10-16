package com.example.Articles.repo

import Article
import android.content.Context

object CategoryOptions {
    const val None = "ALL"
    const val POLITICS = "Politics"
    const val BUSINESS = "Business"
    const val TECHNOLOGY = "Technology"
}

object ArticleRepo {
    private var articles = mutableListOf<Article>()

    fun getArticles(context: Context): List<Article> = TODO()
    fun filterArticles(filter: String): List<Article> = TODO()
}