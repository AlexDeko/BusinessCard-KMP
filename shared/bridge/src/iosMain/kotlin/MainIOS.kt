import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import app.App
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.PredictiveBackGestureIcon
import com.arkivanov.decompose.extensions.compose.jetbrains.PredictiveBackGestureOverlay
import com.arkivanov.essenty.backhandler.BackDispatcher
import root.RootComponent

@OptIn(ExperimentalDecomposeApi::class)
fun MainViewController(
    component: RootComponent,
    backDispatcher: BackDispatcher
) = ComposeUIViewController {
    PredictiveBackGestureOverlay(
        backDispatcher = backDispatcher,
        backIcon = { progress, _ ->
            PredictiveBackGestureIcon(
                imageVector = Icons.Default.ArrowBack,
                progress = progress,
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        App(component, Modifier)
    }
}