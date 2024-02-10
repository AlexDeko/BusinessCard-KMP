package models

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val job: Job,
)


@Serializable
enum class Job {
    DEVELOPER,
    PROJECT_MANAGER,
    QA,
    CEO,
    ADMIN;

    companion object {
        fun create(job: String): Job {
            return when (job) {
                "developer" -> DEVELOPER
                "project_manager" -> PROJECT_MANAGER
                "qa" -> QA
                "ceo" -> CEO
                "admin" -> ADMIN
                else -> error("Unknown job")
            }
        }
    }
}
