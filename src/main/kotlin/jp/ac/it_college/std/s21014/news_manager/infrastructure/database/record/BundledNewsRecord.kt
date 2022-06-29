package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record

    import java.time.LocalDateTime

    data class BundledNewsRecord(
        var id: Long? = null,
        var title: String? = null,
        var body: String? = null,
        var category: String? = null,
        var publishAt: LocalDateTime? = null,
        var createAt: LocalDateTime? = null,
        var postBy: String? = null
    )