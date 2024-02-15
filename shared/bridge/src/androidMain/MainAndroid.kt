import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.App
import root.RootComponent

@Composable
fun MainView(
    component: RootComponent,
    modifier: Modifier = Modifier
) = App(component, modifier)