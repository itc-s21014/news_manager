package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21014.news_manager.domain.model.News
import jp.ac.it_college.std.s21014.news_manager.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21014.news_manager.domain.model.Category
import jp.ac.it_college.std.s21014.news_manager.domain.repository.CategoryRepository
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.*
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.NewsWithCategory as RecordNewsWithCategory

@Repository
class CategoryRepositoryImpl(
    private val newsWithCategoryMapper: NewsWithCategoryMapper,
    private val categoryMapper: CategoryMapper,
    private val newsMapper: NewsMapper
) : CategoryRepository {
    override fun findAllWithNews(): List<NewsWithCategory> {
        return newsWithCategoryMapper.select {  }.map { toModel(it) }
    }

    override fun findWithNews(id: Long): NewsWithCategory? {
        return newsWithCategoryMapper.selectByPrimaryKey(id) {
        }?.let { toModel(it) }
    }

    override fun register(category: Category) {
        categoryMapper.insert(toRecord(category))
    }

    private fun toModel(record: RecordNewsWithCategory): NewsWithCategory {
        val category = Category(
            record.id!!,
            record.title!!,
            record.body
        )
    }
}