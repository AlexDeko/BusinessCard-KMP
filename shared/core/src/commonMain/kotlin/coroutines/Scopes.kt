package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

internal val defaultCoroutineScope
    get() = CoroutineScope(Dispatchers.Default + SupervisorJob())