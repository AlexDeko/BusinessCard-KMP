package root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import employees.DefaultEmployeeListComponent
import kotlinx.serialization.Serializable
import root.model.RootEvent
import sandbox.DefaultSandboxComponent

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent(componentContext) {
    private val navigation = StackNavigation<RootConfig>()

    private val _childStackBottom =
        childStack(
            source = navigation,
            initialConfiguration = RootConfig.EmployeesList,
            serializer = RootConfig.serializer(),
            handleBackButton = false,
            childFactory = ::createChildBottom,
            key = "rootStack"
        )

    override val childStackNavigation: Value<ChildStack<*, ChildBottom>> =
        _childStackBottom

    private fun createChildBottom(
        config: RootConfig,
        componentContext: ComponentContext
    ): ChildBottom =
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

    override fun obtainEvent(event: RootEvent) {
        when (event) {
            is RootEvent.ListEmployeesClicked -> navigation.bringToFront(RootConfig.EmployeesList)
            is RootEvent.SandboxTabClicked -> navigation.bringToFront(RootConfig.Sandbox)
            is RootEvent.BackAction -> navigation.pop()
        }
    }

    @Serializable
    private sealed class RootConfig {
        @Serializable
        data object EmployeesList : RootConfig()

        @Serializable
        data object Sandbox : RootConfig()
    }
}