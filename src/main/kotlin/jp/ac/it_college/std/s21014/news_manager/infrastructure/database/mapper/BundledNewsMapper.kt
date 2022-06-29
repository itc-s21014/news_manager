package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.BundledNewsRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface BundledNewsMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="BundledNewsRecordResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        Result(column="name", property="category", jdbcType=JdbcType.VARCHAR),
        Result(column="publish_at", property="publishAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="view_name", property="postBy", jdbcType=JdbcType.VARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<BundledNewsRecord>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("BundledNewsRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): BundledNewsRecord

}