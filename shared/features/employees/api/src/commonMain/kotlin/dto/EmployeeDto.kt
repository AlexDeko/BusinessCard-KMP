package dto

import kotlinx.serialization.Serializable


@Serializable
data class EmployeeDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val job: String,
)
