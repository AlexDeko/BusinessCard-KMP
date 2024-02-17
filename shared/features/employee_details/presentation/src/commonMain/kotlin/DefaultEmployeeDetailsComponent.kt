import com.arkivanov.decompose.ComponentContext
import decompose.MviComponent
import decompose.State
import models.EmployeeDetailedDataState
import models.EmployeesDetailedEvent

class DefaultEmployeeDetailsComponent(
    component: ComponentContext
) : MviComponent<EmployeeDetailedDataState, EmployeesDetailedEvent>(
    initialState = State.Loading,
    componentContext = component
) {
    override fun obtainEvent(event: EmployeesDetailedEvent) {
        TODO("Not yet implemented")
    }
}