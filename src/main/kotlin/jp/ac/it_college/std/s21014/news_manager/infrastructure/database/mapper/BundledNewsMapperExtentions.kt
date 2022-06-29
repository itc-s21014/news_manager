package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.Category
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.Users
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.BundledNewsRecord
import org.mybatis.dynamic.sql.SqlBuilder.*
import org.mybatis.dynamic.sql.render.RenderingStrategies
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo
import java.time.LocalDateTime

private val columnList = listOf(
    News.id,
    News.title,
    News.body,
    Category.name,
    News.publishAt,
    News.createAt,
    Users.viewName
)

fun BundledNewsMapper.select(includeUnpublished: Boolean, page: Long): List<BundledNewsRecord> {
    val selectStatement = select(columnList)
        .from(News)
        .leftJoin(Category).on(News.categoryId, equalTo(Category.id))
        .leftJoin(Users).on(News.userId, equalTo(Users.id))
    if (!includeUnpublished)
        selectStatement.where(News.publishAt, isLessThan(LocalDateTime.now()))
    selectStatement.orderBy(News.publishAt.descending())
    selectStatement.limit(10).offset((page - 1) * 10)

    return selectMany(selectStatement.build().render(RenderingStrategies.MYBATIS3))
}

fun BundledNewsMapper.selectByPrimaryKey(id: Long, includeUnpublished: Boolean): BundledNewsRecord {
    val selectStatement = select(columnList)
        .from(News)
        .leftJoin(Category).on(News.categoryId, equalTo(Category.id))
        .leftJoin(Users).on(News.userId, equalTo(Users.id))
        .where(News.id, isEqualTo(id))
    if (!includeUnpublished)
        selectStatement.and(News.publishAt, isLessThan(LocalDateTime.now()))

    return selectOne(selectStatement.build().render(RenderingStrategies.MYBATIS3))
}