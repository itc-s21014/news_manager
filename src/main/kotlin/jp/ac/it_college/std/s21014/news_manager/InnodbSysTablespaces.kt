package jp.ac.it_college.std.s21014.news_manager

data class InnodbSysTablespaces(
    var space: Int? = null,
    var name: String? = null,
    var flag: Int? = null,
    var rowFormat: String? = null,
    var pageSize: Int? = null,
    var filename: String? = null,
    var fsBlockSize: Int? = null,
    var fileSize: Long? = null,
    var allocatedSize: Long? = null
)