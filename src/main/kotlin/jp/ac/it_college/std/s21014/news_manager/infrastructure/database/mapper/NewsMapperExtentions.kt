package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.NewsRecord
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News.body
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News.categoryId
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News.createAt
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News.id
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News.publishAt
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News.title
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.News.userId
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun NewsMapper.count(completer: CountCompleter) =
    countFrom(this::count, News, completer)

fun NewsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, News, completer)

fun NewsMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun NewsMapper.insert(record: NewsRecord) =
    insert(this::insert, record, News) {
        map(id).toProperty("id")
        map(title).toProperty("title")
        map(categoryId).toProperty("categoryId")
        map(publishAt).toProperty("publishAt")
        map(createAt).toProperty("createAt")
        map(userId).toProperty("userId")
        map(body).toProperty("body")
    }

fun NewsMapper.insertMultiple(records: Collection<NewsRecord>) =
    insertMultiple(this::insertMultiple, records, News) {
        map(id).toProperty("id")
        map(title).toProperty("title")
        map(categoryId).toProperty("categoryId")
        map(publishAt).toProperty("publishAt")
        map(createAt).toProperty("createAt")
        map(userId).toProperty("userId")
        map(body).toProperty("body")
    }

fun NewsMapper.insertMultiple(vararg records: NewsRecord) =
    insertMultiple(records.toList())

fun NewsMapper.insertSelective(record: NewsRecord) =
    insert(this::insert, record, News) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(title).toPropertyWhenPresent("title", record::title)
        map(categoryId).toPropertyWhenPresent("categoryId", record::categoryId)
        map(publishAt).toPropertyWhenPresent("publishAt", record::publishAt)
        map(createAt).toPropertyWhenPresent("createAt", record::createAt)
        map(userId).toPropertyWhenPresent("userId", record::userId)
        map(body).toPropertyWhenPresent("body", record::body)
    }

private val columnList = listOf(id, title, categoryId, publishAt, createAt, userId, body)

fun NewsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, News, completer)

fun NewsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, News, completer)

fun NewsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, News, completer)

fun NewsMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun NewsMapper.update(completer: UpdateCompleter) =
    update(this::update, News, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: NewsRecord) =
    apply {
        set(id).equalTo(record::id)
        set(title).equalTo(record::title)
        set(categoryId).equalTo(record::categoryId)
        set(publishAt).equalTo(record::publishAt)
        set(createAt).equalTo(record::createAt)
        set(userId).equalTo(record::userId)
        set(body).equalTo(record::body)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: NewsRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(title).equalToWhenPresent(record::title)
        set(categoryId).equalToWhenPresent(record::categoryId)
        set(publishAt).equalToWhenPresent(record::publishAt)
        set(createAt).equalToWhenPresent(record::createAt)
        set(userId).equalToWhenPresent(record::userId)
        set(body).equalToWhenPresent(record::body)
    }

fun NewsMapper.updateByPrimaryKey(record: NewsRecord) =
    update {
        set(title).equalTo(record::title)
        set(categoryId).equalTo(record::categoryId)
        set(publishAt).equalTo(record::publishAt)
        set(createAt).equalTo(record::createAt)
        set(userId).equalTo(record::userId)
        set(body).equalTo(record::body)
        where(id, isEqualTo(record::id))
    }

fun NewsMapper.updateByPrimaryKeySelective(record: NewsRecord) =
    update {
        set(title).equalToWhenPresent(record::title)
        set(categoryId).equalToWhenPresent(record::categoryId)
        set(publishAt).equalToWhenPresent(record::publishAt)
        set(createAt).equalToWhenPresent(record::createAt)
        set(userId).equalToWhenPresent(record::userId)
        set(body).equalToWhenPresent(record::body)
        where(id, isEqualTo(record::id))
    }