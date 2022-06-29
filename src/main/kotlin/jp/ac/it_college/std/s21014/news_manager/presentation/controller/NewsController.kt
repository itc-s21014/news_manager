package jp.ac.it_college.std.s21014.news_manager.presentation.controller

import jp.ac.it_college.std.s21014.news_manager.application.service.NewsManagerUserDetails
import jp.ac.it_college.std.s21014.news_manager.application.service.NewsService
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.BundledNewsRecord
import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.NewsRecord
import jp.ac.it_college.std.s21014.news_manager.domain.enum.RoleType
import jp.ac.it_college.std.s21014.news_manager.domain.repository.CategoryRepository
import jp.ac.it_college.std.s21014.news_manager.presentation.form.RegisterNewsRequest
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class NewsController(
    private val newsService: NewsService,
    private val categoryRepository: CategoryRepository
) {

    @RequestMapping("/news")
    fun getNews(
        @RequestParam("page", name = "page", required = false, defaultValue = "1") page: Long,
        authentication: Authentication?
    ): List<BundledNewsRecord> {
        val isAdmin =
            authentication?.authorities?.map { RoleType.valueOf(it.authority) }?.contains(RoleType.ADMIN) ?: false
        return newsService.getList(isAdmin, page)
    }

    @GetMapping("/news/{id}")
    fun getNewsDetail(@PathVariable id: Long, authentication: Authentication?): BundledNewsRecord {
        val isAdmin =
            authentication?.authorities?.map { RoleType.valueOf(it.authority) }?.contains(RoleType.ADMIN) ?: false
        return newsService.getById(id, isAdmin)
    }

    @PostMapping("/post")
    fun register(@RequestBody request: RegisterNewsRequest, authentication: Authentication) {
        categoryRepository.findById(request.categoryId)
            ?: throw IllegalArgumentException("存在しないカテゴリID: ${request.categoryId}")
        val principal = authentication.principal as NewsManagerUserDetails
        newsService.register(
            NewsRecord(
                0,
                request.title,
                request.categoryId,
                request.publishAt,
                LocalDateTime.now(),
                principal.id,
                request.body
            )
        )
    }
}
