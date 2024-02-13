package decompose

interface SandboxNavigator : Navigator<SandboxNavigator.Child> {

    sealed class Child {
        data object Sandbox : Child()
    }
}