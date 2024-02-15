package root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import decompose.EmployeeListNavigator
import employees.DefaultEmployeeListComponent


interface RootComponent {
    val childStackBottom: Value<ChildStack<*, ChildBottom>>

    fun openListEmployees()

    //fun openAboutCompany()


    sealed class ChildBottom {
        class EmployeesListChild(
            val component: DefaultEmployeeListComponent,
            val navigator: EmployeeListNavigator,
        ) : ChildBottom()


        //TODO
        // class AboutOfCompanyChild(val component: BuyComponent) : ChildBottom()
    }

}