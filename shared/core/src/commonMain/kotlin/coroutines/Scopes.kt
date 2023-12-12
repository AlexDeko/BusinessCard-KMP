package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

internal val coroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())