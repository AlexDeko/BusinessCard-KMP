package root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.active
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.Lifecycle
import decompose.BaseComponent
import employee.DefaultEmployeeListComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext
) : BaseComponent(), RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<ConfigBottom>()

    private val _childStackBottom =
        childStack(
            source = navigationBottomStackNavigation,
            initialConfiguration = ConfigBottom.Welcome,
            handleBackButton = true,
            childFactory = ::createChildBottom,
            key = "authStack"
        )

    override val childStackBottom: Value<ChildStack<*, RootComponent.ChildBottom>> =
        _childStackBottom


    private fun createChildBottom(
        config: ConfigBottom,
        componentContext: ComponentContext
    ): RootComponent.ChildBottom =
        when (config) {

            is ConfigBottom.Welcome -> RootComponent.ChildBottom.WelcomeChild(
                welcomeComponent(componentContext)
            )

            is ConfigBottom.Feeds -> RootComponent.ChildBottom.FeedsChild(
                feedsComponent(componentContext)
            )

            is ConfigBottom.Message -> RootComponent.ChildBottom.MessageChild(
                messageComponent(componentContext)
            )

            is ConfigBottom.Notification -> RootComponent.ChildBottom.NotificationsChild(
                notificationComponent(componentContext)
            )
        }


    private fun welcomeComponent(componentContext: ComponentContext): HomeComponent =
        DefaultEmployeeListComponent(
            componentContext = componentContext,
        )

    override fun openListEmployees() {
        navigationBottomStackNavigation.bringToFront(RootConfig.ListEmployees)
    }

    private sealed class RootConfig {
        @Serializable
        data object ListEmployees : RootConfig()
    }

    init {
        lifecycle.subscribe(object : Lifecycle.Callbacks {
            override fun onResume() {
                when (childStackBottom.active.configuration) {
                    is ConfigBottom.Message -> {
                        super.onResume()
                    }

                }
            }
        })

    }

}