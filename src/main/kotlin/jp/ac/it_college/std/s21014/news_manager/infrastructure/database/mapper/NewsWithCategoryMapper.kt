package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.category
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.id
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.name
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.body
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.createAt
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.news
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.publishAt
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.title
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.userId
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.NewsWithCategory
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select

@Mapper
interface NewsWithCategoryMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "NewsWithCategoryResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "category_Id", property = "categoryId", jdbcType = JdbcType.BIGINT),
            Result(column = "publish_At", property = "publishAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "create_At", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "user_Id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "body", property = "body", jdbcType = JdbcType.VARCHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<NewsWithCategory>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("NewsWithCategory")
    fun selectOne(selectStatement: SelectStatementProvider): NewsWithCategory?
}

private val columList = listOf(id, name, title, categoryId, publishAt, createAt, userId, body)

fun NewsWithCategoryMapper.select(completer: SelectCompleter): List<NewsWithCategory> =
    select(columList) {
        from(category, "c")
        leftJoin(news, "n") {
            on(category.id) equalTo news.categoryId
        }
        where {
            id isEqualTo id_
        }
    }