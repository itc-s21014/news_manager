package jp.ac.it_college.std.s21014.news_manager.presentation.controller

import jp.ac.it_college.std.s21014.news_manager.application.service.security.AdminUserService
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.UsersRecord
import jp.ac.it_college.std.s21014.news_manager.presentation.config.SecurityConfig
import jp.ac.it_college.std.s21014.news_manager.presentation.form.RegisterUserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/user")
class AdminUserController(
    private val adminUserService: AdminUserService,
    private val securityConfig: SecurityConfig
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterUserRequest) {
        request.password = securityConfig.passwordEncoder().encode(request.password)
        adminUserService.register(
            UsersRecord(
                0,
                request.username,
                request.password,
                request.viewName,
                request.roleType
            )
        )
    }
}