package jp.ac.it_college.std.s21014.news_manager.application.security

import jp.ac.it_college.std.s21014.news_manager.application.service.AuthenticationService
import jp.ac.it_college.std.s21014.news_manager.domain.enum.RoleType
import jp.ac.it_college.std.s21014.news_manager.domain.model.Users
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class NewsManagerUserDetailsService(
    private val authenticationService: AuthenticationService
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? {
        val users = authenticationService.findUser(username ?: "")
        return users?
    }
}

data class NewsManagerUserDetails(
    val id: Long, val username: String, val pass: String, val roleType: RoleType
) : UserDetails {
        constructor(users: Users) : this(
            users.id, users.username, users.password, users.role_Type
        )


}