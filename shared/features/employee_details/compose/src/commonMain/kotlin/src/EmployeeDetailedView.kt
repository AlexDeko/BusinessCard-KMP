import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import models.Employee

@Composable
fun EmployeeDetailedView(employee: Employee) {

    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Text(
            text = "${employee.firstName} ${employee.lastName}"
        )
    }
}