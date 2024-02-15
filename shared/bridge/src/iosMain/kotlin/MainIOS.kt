import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import app.App
import root.RootComponent

fun MainViewController(
    component: RootComponent
) = ComposeUIViewController { App(component, Modifier) }