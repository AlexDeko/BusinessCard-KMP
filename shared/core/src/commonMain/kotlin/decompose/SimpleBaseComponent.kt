package decompose

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

abstract class SimpleBaseComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext, KoinComponent