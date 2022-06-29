package jp.ac.it_college.std.s21014.news_manager.application.service.security

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.UsersRecord
import jp.ac.it_college.std.s21014.news_manager.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AdminUserService(
    private val userRepository: UserRepository
) {
    fun register(user: UsersRecord) {
        userRepository.find(user.username!!)?.let { throw IllegalArgumentException("存在するユーザー: ${user.username}") }
        userRepository.register(user)
    }
}