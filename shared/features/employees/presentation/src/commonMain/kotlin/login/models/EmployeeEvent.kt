package login.models

sealed class EmployeeEvent {
    data class ClickEmployee(
        val employeeId: Long
    ) : EmployeeEvent()
}
