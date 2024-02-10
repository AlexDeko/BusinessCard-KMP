package coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

object Dispatchers {

    val Default: CoroutineDispatcher = Dispatchers.Default

    val IO: CoroutineDispatcher = Dispatchers.IO

    val Main: CoroutineDispatcher = Dispatchers.Main
}


