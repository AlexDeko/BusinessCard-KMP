package login.models

sealed class EmployeeAction {
    data object ShowMessage : EmployeeAction()
}
