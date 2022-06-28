package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21014.news_manager.domain.model.News
import jp.ac.it_college.std.s21014.news_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsMapper
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.deleteByPrimaryKey
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.News as RecordNews

class NewsRepositoryImpl(
    private val newsMapper: NewsMapper
) : NewsRepository {
    override fun startNews(news: News) {
        newsMapper.insert(toRecord(news))
    }

    override fun endNews(categoryId: Long) {
        newsMapper.deleteByPrimaryKey(categoryId)
    }

    private fun toRecord(model: News): RecordNews {
        return RecordNews(model.id, model)
    }
}