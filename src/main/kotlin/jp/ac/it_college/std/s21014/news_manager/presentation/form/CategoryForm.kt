package jp.ac.it_college.std.s21014.news_manager.presentation.form

import jp.ac.it_college.std.s21014.news_manager.domain.model.News
import jp.ac.it_college.std.s21014.news_manager.domain.model.NewsWithCategory
import java.time.LocalDate
import java.time.LocalDateTime

data class GetCategoryListResponse(val categoryList: List<CategoryInfo>)

data class CategoryInfo(
    val id: Long,
    val name: String,
    val title: String,
    val isNews: Boolean
) {
    constructor(model: NewsWithCategory) : this(
        model.category.id, model.category.name, model.isNews
    )
}

data class GetCategoryDetailResponse(
    val id: Long,
    val name: String,
    val title: String,
    val body: String,
    val newsInfo: NewsInfo?
) {
   constructor(model: NewsWithCategory): this(
       model.category.id,
       model.category.name,
       model.news?.let { NewsInfo(model.news) }
   )
}

data class NewsInfo(
    val userId: Long,
    val publishAt: LocalDateTime,
    val createAt: LocalDateTime
) {
  constructor(news: News): this(
      news.userId,
      news.publishAt,
      news.createAt
  )
}
