package jp.ac.it_college.std.s21014.news_manager.application.service

import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.UsersRecord
import jp.ac.it_college.std.s21014.news_manager.domain.enum.RoleType
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class NewsManagerUserDetailsService(
    private val authenticationService: AuthenticationService
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails? {
        val user = authenticationService.findUser(username)
        return user?.let { NewsManagerUserDetails(it) }
    }
}

data class NewsManagerUserDetails(
    val id: Long,
    val user: String,
    val pass: String,
    val viewName: String,
    val roleType: RoleType
) : UserDetails {

    constructor(user: UsersRecord) :
            this(user.id!!,
                user.username!!,
                user.password!!,
                user.viewName!!,
                user.roleType!!)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(this.roleType.toString())
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.user
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return pass
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}