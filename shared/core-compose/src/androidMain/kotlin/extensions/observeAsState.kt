package extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

@Composable
actual inline fun <T> StateFlow<T>.observeAsState(context: CoroutineContext): State<T> {
    return collectAsStateWithLifecycle(context = context)
}

@Composable
actual inline fun <T> SharedFlow<T>.observeAsState(context: CoroutineContext): State<T?> {
    return collectAsStateWithLifecycle(initialValue = null, context = context)
}