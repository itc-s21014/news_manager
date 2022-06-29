package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.CategoryRecord
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.Category
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.Category.id
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.Category.name
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun CategoryMapper.count(completer: CountCompleter) =
    countFrom(this::count, Category, completer)

fun CategoryMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Category, completer)

fun CategoryMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun CategoryMapper.insert(record: CategoryRecord) =
    insert(this::insert, record, Category) {
        map(id).toProperty("id")
        map(name).toProperty("name")
    }

fun CategoryMapper.insertMultiple(records: Collection<CategoryRecord>) =
    insertMultiple(this::insertMultiple, records, Category) {
        map(id).toProperty("id")
        map(name).toProperty("name")
    }

fun CategoryMapper.insertMultiple(vararg records: CategoryRecord) =
    insertMultiple(records.toList())

fun CategoryMapper.insertSelective(record: CategoryRecord) =
    insert(this::insert, record, Category) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(name).toPropertyWhenPresent("name", record::name)
    }

private val columnList = listOf(id, name)

fun CategoryMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Category, completer)

fun CategoryMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Category, completer)

fun CategoryMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Category, completer)

fun CategoryMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun CategoryMapper.update(completer: UpdateCompleter) =
    update(this::update, Category, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: CategoryRecord) =
    apply {
        set(id).equalTo(record::id)
        set(name).equalTo(record::name)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: CategoryRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(name).equalToWhenPresent(record::name)
    }

fun CategoryMapper.updateByPrimaryKey(record: CategoryRecord) =
    update {
        set(name).equalTo(record::name)
        where(id, isEqualTo(record::id))
    }

fun CategoryMapper.updateByPrimaryKeySelective(record: CategoryRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        where(id, isEqualTo(record::id))
    }