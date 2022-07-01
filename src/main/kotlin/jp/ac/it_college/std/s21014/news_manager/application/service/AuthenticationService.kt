package jp.ac.it_college.std.s21014.news_manager.application.service

import jp.ac.it_college.std.s21014.news_manager.domain.repository.UserRepository
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.Users
import org.springframework.stereotype.Service

@Service
class AuthenticationService(private val userRepository: UserRepository) {
    fun findUsers(username: String): Users? {
        return userRepository.find(username)
    }
}