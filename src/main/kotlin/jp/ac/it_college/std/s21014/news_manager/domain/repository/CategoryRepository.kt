package jp.ac.it_college.std.s21014.news_manager.domain.repository

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.CategoryRecord

interface CategoryRepository {
    fun findAll(): List<CategoryRecord>
    fun findById(id: Long): CategoryRecord?
    fun findByName(name: String): CategoryRecord?

    fun register(category: CategoryRecord)
    fun delete(id: Long)
    fun updateName(id: Long, name: String)
}