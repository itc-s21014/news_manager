package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.*
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.BundledNewsRecord
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.NewsRecord
import jp.ac.it_college.std.s21014.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Repository

@Repository
class NewsRepositoryImpl(
    private val bundledNewsMapper: BundledNewsMapper,
    private val newsMapper: NewsMapper
) : NewsRepository {
    override fun findAll(includeUnpublished: Boolean, page: Long): List<BundledNewsRecord> {
        return bundledNewsMapper.select(includeUnpublished, page)
    }

    override fun findById(id: Long, includeUnpublished: Boolean): BundledNewsRecord {
        return bundledNewsMapper.selectByPrimaryKey(id, includeUnpublished)
    }

    override fun register(news: NewsRecord) {
        newsMapper.insert(news)
    }
}