package extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext


@Composable
actual fun <T> StateFlow<T>.collectAsStateMultiPlatform(context: CoroutineContext): State<T> {
    return collectAsState(context)
}