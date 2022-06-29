package jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper

    import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.record.UsersRecord
    import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.Users
    import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.Users.id
    import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.Users.password
    import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.Users.roleType
    import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.Users.username
    import jp.ac.it_college.std.s21014.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.Users.viewName
    import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
    import org.mybatis.dynamic.sql.util.kotlin.*
    import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

    fun UsersMapper.count(completer: CountCompleter) =
        countFrom(this::count, Users, completer)

    fun UsersMapper.delete(completer: DeleteCompleter) =
        deleteFrom(this::delete, Users, completer)

    fun UsersMapper.deleteByPrimaryKey(id_: Long) =
        delete {
            where(id, isEqualTo(id_))
        }

    fun UsersMapper.insert(record: UsersRecord) =
        insert(this::insert, record, Users) {
            map(id).toProperty("id")
            map(username).toProperty("username")
            map(password).toProperty("password")
            map(viewName).toProperty("viewName")
            map(roleType).toProperty("roleType")
        }

    fun UsersMapper.insertMultiple(records: Collection<UsersRecord>) =
        insertMultiple(this::insertMultiple, records, Users) {
            map(id).toProperty("id")
            map(username).toProperty("username")
            map(password).toProperty("password")
            map(viewName).toProperty("viewName")
            map(roleType).toProperty("roleType")
        }

    fun UsersMapper.insertMultiple(vararg records: UsersRecord) =
        insertMultiple(records.toList())

    fun UsersMapper.insertSelective(record: UsersRecord) =
        insert(this::insert, record, Users) {
            map(id).toPropertyWhenPresent("id", record::id)
            map(username).toPropertyWhenPresent("username", record::username)
            map(password).toPropertyWhenPresent("password", record::password)
            map(viewName).toPropertyWhenPresent("viewName", record::viewName)
            map(roleType).toPropertyWhenPresent("roleType", record::roleType)
        }

    private val columnList = listOf(id, username, password, viewName, roleType)

    fun UsersMapper.selectOne(completer: SelectCompleter) =
        selectOne(this::selectOne, columnList, Users, completer)

    fun UsersMapper.select(completer: SelectCompleter) =
        selectList(this::selectMany, columnList, Users, completer)

    fun UsersMapper.selectDistinct(completer: SelectCompleter) =
        selectDistinct(this::selectMany, columnList, Users, completer)

    fun UsersMapper.selectByPrimaryKey(id_: Long) =
        selectOne {
            where(id, isEqualTo(id_))
        }

    fun UsersMapper.update(completer: UpdateCompleter) =
        update(this::update, Users, completer)

    fun KotlinUpdateBuilder.updateAllColumns(record: UsersRecord) =
        apply {
            set(id).equalTo(record::id)
            set(username).equalTo(record::username)
            set(password).equalTo(record::password)
            set(viewName).equalTo(record::viewName)
            set(roleType).equalTo(record::roleType)
        }

    fun KotlinUpdateBuilder.updateSelectiveColumns(record: UsersRecord) =
        apply {
            set(id).equalToWhenPresent(record::id)
            set(username).equalToWhenPresent(record::username)
            set(password).equalToWhenPresent(record::password)
            set(viewName).equalToWhenPresent(record::viewName)
            set(roleType).equalToWhenPresent(record::roleType)
        }

    fun UsersMapper.updateByPrimaryKey(record: UsersRecord) =
        update {
            set(username).equalTo(record::username)
            set(password).equalTo(record::password)
            set(viewName).equalTo(record::viewName)
            set(roleType).equalTo(record::roleType)
            where(id, isEqualTo(record::id))
        }

    fun UsersMapper.updateByPrimaryKeySelective(record: UsersRecord) =
        update {
            set(username).equalToWhenPresent(record::username)
            set(password).equalToWhenPresent(record::password)
            set(viewName).equalToWhenPresent(record::viewName)
            set(roleType).equalToWhenPresent(record::roleType)
            where(id, isEqualTo(record::id))
        }