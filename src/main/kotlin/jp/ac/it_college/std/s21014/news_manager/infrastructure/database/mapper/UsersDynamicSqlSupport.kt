package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

import java.sql.JDBCType
import jp.ac.it_college.std.s21014.news_manager.domain.enum.RoleType
import org.mybatis.dynamic.sql.SqlTable

object UsersDynamicSqlSupport {
    object Users : SqlTable("users") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val username = column<String>("username", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)

        val viewName = column<String>("view_name", JDBCType.VARCHAR)

        val roleType = column<RoleType>("role_type", JDBCType.VARCHAR, "org.apache.ibatis.type.EnumTypeHandler")
    }
}