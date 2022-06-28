package jp.ac.it_college.std.s21014.news_manager.domain.repository

import jp.ac.it_college.std.s21014.news_manager.domain.model.News

interface NewsRepository {
    fun startNews(news: News)

    fun endNews(categoryId: Long)
}