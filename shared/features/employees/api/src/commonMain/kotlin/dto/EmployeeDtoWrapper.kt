package dto

import kotlinx.serialization.Serializable

@Serializable
data class EmployeeDtoWrapper(val employees: List<EmployeeDto>)