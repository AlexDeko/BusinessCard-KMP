package employee

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import models.Employee

@Composable
fun EmployeeDetailedView(employee: Employee) {

    Text(text = "${employee.firstName} ${employee.lastName}")
}