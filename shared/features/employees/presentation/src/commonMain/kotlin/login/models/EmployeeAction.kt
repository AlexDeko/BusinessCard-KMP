package login.models

sealed class EmployeeAction {
    data class ShowMessage(
        val employeeId: Long
    ) : EmployeeAction()
}
