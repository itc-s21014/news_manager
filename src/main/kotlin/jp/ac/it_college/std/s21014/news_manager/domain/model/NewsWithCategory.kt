package jp.ac.it_college.std.s21014.news_manager.domain.model

data class NewsWithCategory(
    val category: Category,
    val news: News?,
) {
    val isNews: Boolean
        get() = news != null
}
