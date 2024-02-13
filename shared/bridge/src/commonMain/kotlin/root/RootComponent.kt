package root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import decompose.EmployeeListNavigator
import decompose.SandboxNavigator
import employees.DefaultEmployeeListComponent
import employees.DefaultSandboxComponent


interface RootComponent {
    val childStackBottom: Value<ChildStack<*, ChildBottom>>

    fun openListEmployees()

    fun openSandbox()

    //fun openAboutCompany()


    sealed class ChildBottom {
        class EmployeesListChild(
            val component: DefaultEmployeeListComponent,
            val navigator: EmployeeListNavigator,
        ) : ChildBottom()

        class SandboxChild(val component: DefaultSandboxComponent, val navigator: SandboxNavigator): ChildBottom()

        //TODO
        // class AboutOfCompanyChild(val component: BuyComponent) : ChildBottom()
    }

}