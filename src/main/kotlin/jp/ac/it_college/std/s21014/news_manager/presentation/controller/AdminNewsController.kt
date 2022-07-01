package jp.ac.it_college.std.s21014.news_manager.presentation.controller

import jp.ac.it_college.std.s21014.news_manager.application.security.NewsManagerUserDetails
import jp.ac.it_college.std.s21014.news_manager.application.service.AdminNewsService
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.News
import jp.ac.it_college.std.s21014.news_manager.presentation.form.RegisterNewsRequest
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("admin/news")
@CrossOrigin(origins = ["http://localhost:8081"], allowCredentials = "true")
class AdminNewsController(
    private val adminNewsService: AdminNewsService,
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterNewsRequest, authentication: Authentication) {
        val pribcipal = authentication.principal as NewsManagerUserDetails
        adminNewsService.register(
            News(
                0,
                request.title,
                request.categoryId,
                request.publishAt,
                LocalDateTime.now(),
                1,
                request.body
            )
        )
    }
}