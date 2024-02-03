package root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import decompose.EmployeeListComponent


interface RootComponent {
    val childStackBottom: Value<ChildStack<*, ChildBottom>>

    fun openListEmployees()

    //fun openAboutCompany()


    sealed class ChildBottom {
        class EmployeesListChild(val component: EmployeeListComponent) : ChildBottom()
        //TODO
        // class AboutOfCompanyChild(val component: BuyComponent) : ChildBottom()
    }

}