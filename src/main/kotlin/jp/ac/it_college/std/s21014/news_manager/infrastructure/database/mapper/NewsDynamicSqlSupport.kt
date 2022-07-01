package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.SqlTable

object NewsDynamicSqlSupport {
    object News : SqlTable("news") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val title = column<String>("title", JDBCType.VARCHAR)

        val categoryId = column<Long>("category_id", JDBCType.BIGINT)

        val publishAt = column<LocalDateTime>("publish_at", JDBCType.TIMESTAMP)

        val createAt = column<LocalDateTime>("create_at", JDBCType.TIMESTAMP)

        val userId = column<Long>("user_id", JDBCType.BIGINT)

        val body = column<String>("body", JDBCType.LONGVARCHAR)
    }
}