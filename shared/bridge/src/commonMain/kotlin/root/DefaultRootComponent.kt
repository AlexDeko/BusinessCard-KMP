package root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import decompose.SimpleBaseComponent
import employees.DefaultEmployeeListComponent
import kotlinx.serialization.Serializable
import sandbox.DefaultSandboxComponent

class DefaultRootComponent(
    componentContext: ComponentContext
) : SimpleBaseComponent(componentContext), RootComponent {
    private val navigation = StackNavigation<RootConfig>()

    private val _childStackBottom =
        childStack(
            source = navigation,
            initialConfiguration = RootConfig.EmployeesList,
            serializer = RootConfig.serializer(),
            handleBackButton = true,
            childFactory = ::createChildBottom,
            key = "rootStack"
        )

    override val childStackBottom: Value<ChildStack<*, RootComponent.ChildBottom>> =
        _childStackBottom


    private fun createChildBottom(
        config: RootConfig,
        componentContext: ComponentContext
    ): RootComponent.ChildBottom =
        when (config) {
            is RootConfig.EmployeesList -> {
                val componentWithNavigation = employeeListComponent(componentContext)
                RootComponent.ChildBottom.EmployeesListChild(
                    component = componentWithNavigation,
                    navigator = componentWithNavigation
                )
            }

            is RootConfig.Sandbox -> {
                val componentWithNavigation = sandboxComponent(componentContext)
                RootComponent.ChildBottom.SandboxChild(
                    component = componentWithNavigation,
                    navigator = componentWithNavigation
                )
            }
        }

    private fun employeeListComponent(componentContext: ComponentContext) =
        DefaultEmployeeListComponent(
            componentContext = componentContext,
        )

    private fun sandboxComponent(componentContext: ComponentContext) =
        DefaultSandboxComponent(componentContext)

    override fun openListEmployees() {
        navigation.bringToFront(RootConfig.EmployeesList)
    }

    override fun openSandbox() {
        navigation.bringToFront(RootConfig.Sandbox)
    }

    @Serializable
    private sealed class RootConfig {
        @Serializable
        data object EmployeesList : RootConfig()

        @Serializable
        data object Sandbox : RootConfig()
    }
}