package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record

import java.sql.Timestamp

data class NewsWithCategoryRecord(
    val id: Long? = null,
    val title: String? = null,
    val categoryId: Long? = null,
    val createAt: Timestamp? = null,
    val publishAt: Timestamp? = null,
    val userId: Long? = null,
    val body: String? = null,
    val name: String? = null,
)