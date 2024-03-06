package root

import com.arkivanov.decompose.ComponentContext
import decompose.ComponentWithNavigation
import decompose.EmployeeListNavigator
import decompose.SandboxNavigator
import decompose.State
import employees.DefaultEmployeeListComponent
import root.model.RootEvent
import sandbox.DefaultSandboxComponent


abstract class RootComponent(
    componentContext: ComponentContext
) : ComponentWithNavigation<Unit, RootEvent, RootComponent.ChildBottom>(
    componentContext = componentContext,
    initialState = State.Success(Unit)
) {

    sealed class ChildBottom {
        class EmployeesListChild(
            val component: DefaultEmployeeListComponent,
            val navigator: EmployeeListNavigator,
        ) : ChildBottom()

        class SandboxChild(
            val component: DefaultSandboxComponent,
            val navigator: SandboxNavigator
        ) : ChildBottom()

        //TODO
        // class AboutOfCompanyChild(val component: BuyComponent) : ChildBottom()
    }

}