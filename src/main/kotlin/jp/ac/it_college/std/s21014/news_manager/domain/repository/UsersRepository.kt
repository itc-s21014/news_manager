package jp.ac.it_college.std.s21014.news_manager.domain.repository

import jp.ac.it_college.std.s21014.news_manager.domain.model.Users

interface UsersRepository {
    fun find(username: String): Users?

    fun find(id: Long): Users?
}