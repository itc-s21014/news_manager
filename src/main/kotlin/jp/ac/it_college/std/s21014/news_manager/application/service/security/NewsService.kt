package jp.ac.it_college.std.s21014.news_manager.application.service

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.BundledNewsRecord
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.NewsRecord
import jp.ac.it_college.std.s21014.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository
) {
    fun getList(includeUnpublished: Boolean, page: Long) : List<BundledNewsRecord> {
        return newsRepository.findAll(includeUnpublished, page)
    }

    fun getById(id: Long, includeUnpublished: Boolean) : BundledNewsRecord {
        return newsRepository.findById(id, includeUnpublished)
    }

    fun register(news: NewsRecord) {
        newsRepository.register(news)
    }
}