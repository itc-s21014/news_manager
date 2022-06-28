package jp.ac.it_college.std.s21014.news_manager.presentation.controller

import jp.ac.it_college.std.s21014.news_manager.presentation.form.NewsStartRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("news")
@CrossOrigin
data class NewsController(
    private val newsService: NewsService
) {
    @PostMapping("/start")
    fun startNews(@RequestBody request: NewsStartRequest) {
        val users = SecurityContextHolder.getContext().authentication.principal as

    }
}
