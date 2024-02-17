package extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Composable
expect inline fun <T> StateFlow<T>.observeAsState(context: CoroutineContext = EmptyCoroutineContext): State<T>

@Composable
expect inline fun <T> SharedFlow<T>.observeAsState(context: CoroutineContext): State<T?>