package sandbox

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import decompose.MviComponent
import decompose.SandboxNavigator
import decompose.State
import kotlinx.serialization.Serializable
import sandbox.models.SandboxDefaultState
import sandbox.models.SandboxEvent

class DefaultSandboxComponent(private val componentContext: ComponentContext) :
    MviComponent<SandboxDefaultState, SandboxEvent>(componentContext, State.Loading),
    SandboxNavigator {
    override fun obtainEvent(event: SandboxEvent) {
        TODO("Not yet implemented")
    }

    private val navigation = StackNavigation<SandboxConfig>()

    private val _childStackNavigation = childStack(
        source = navigation,
        initialConfiguration = SandboxConfig.Sandbox,
        serializer = SandboxConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild,
        key = "sandboxStack",
    )

    private fun createChild(
        config: SandboxConfig,
        componentContext: ComponentContext
    ): SandboxNavigator.Child =
        when (config) {
            is SandboxConfig.Sandbox -> SandboxNavigator.Child.Sandbox
        }

    override val childStackNavigation: Value<ChildStack<*, SandboxNavigator.Child>>
        get() = _childStackNavigation


}

@Serializable
private sealed class SandboxConfig {
    @Serializable
    data object Sandbox : SandboxConfig()
}