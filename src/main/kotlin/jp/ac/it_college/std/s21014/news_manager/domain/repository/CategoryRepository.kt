package jp.ac.it_college.std.s21014.news_manager.domain.repository

import jp.ac.it_college.std.s21014.news_manager.domain.model.Category
import jp.ac.it_college.std.s21014.news_manager.domain.model.NewsWithCategory

interface CategoryRepository {
    fun findAllWithNews(): List<NewsWithCategory>

    fun findWithNews(id: Long): NewsWithCategory?

    fun register(category: Category)
}