package oop_00000070427_sinatriyaariaputra.week14

interface Database {
    fun query(sql: String): List<String>
}

class PostgresDatabase : Database {
    override fun query(sql: String) = listOf("pg_data1", "pg_data2")
}

class MongoDatabase : Database {
    override fun query(sql: String) = listOf("mongo_data1", "mongo_data2")
}

class SafeUserService(private val db: Database) {
    fun getUser(id: Int) = db.query("SELECT * FROM users WHERE id=$id")
}
