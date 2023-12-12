package login.models

sealed class EmployeeEvent {
    data object ClickEmployee : EmployeeEvent()
}
