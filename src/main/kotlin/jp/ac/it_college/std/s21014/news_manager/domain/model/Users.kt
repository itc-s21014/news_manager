package jp.ac.it_college.std.s21014.news_manager.domain.model

import jp.ac.it_college.std.s21014.news_manager.domain.enum.RoleType

data class Users(
    val id: Long,
    val username: String,
    val password: String,
    val viewName: String,
    val role_Type: RoleType
)
