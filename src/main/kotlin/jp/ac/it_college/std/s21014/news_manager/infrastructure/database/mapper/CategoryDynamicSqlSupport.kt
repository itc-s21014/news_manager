package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object CategoryDynamicSqlSupport {
    object Category : SqlTable("category") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)
    }
}