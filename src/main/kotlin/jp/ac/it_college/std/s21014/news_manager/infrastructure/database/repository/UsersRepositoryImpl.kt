package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21014.news_manager.domain.model.Users
import jp.ac.it_college.std.s21014.news_manager.domain.repository.UsersRepository
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.users
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersMapper
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.selectByPrimaryKey
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.selectOne
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.Users as RecordUsers

@Repository
class UsersRepositoryImpl(
    private val mapper: UsersMapper
) : UsersRepository {
    override fun find(username: String): Users? {
        val record = mapper.selectOne {
            where {
                users.username isEqualTo username
            }
        }

        return record?.let { toModel(it) }
    }

    override fun find(id: Long): Users? {
        val record = mapper.selectByPrimaryKey(id)
        return record?.let { toModel(it) }
    }

    private fun toModel(record: RecordUsers): Users {
        return Users(
            record.id!!,
            record.username!!,
            record.password!!,
            record.viewName!!,
            record.roleType!!
        )
    }
}