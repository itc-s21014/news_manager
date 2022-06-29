package jp.ac.it_college.std.s21014.news_manager.domain.repository

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.BundledNewsRecord
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.NewsRecord

interface NewsRepository {
    fun findAll(includeUnpublished: Boolean, page: Long) : List<BundledNewsRecord>
    fun findById(id: Long, includeUnpublished: Boolean) : BundledNewsRecord
    fun register(news: NewsRecord)
}