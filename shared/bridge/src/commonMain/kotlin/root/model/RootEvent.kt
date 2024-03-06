package root.model

sealed interface RootEvent {

    data object BackAction : RootEvent

    data object ListEmployeesClicked : RootEvent

    data object SandboxTabClicked : RootEvent
}