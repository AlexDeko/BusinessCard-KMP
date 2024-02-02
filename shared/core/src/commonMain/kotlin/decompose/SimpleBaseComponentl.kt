package decompose

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

abstract class BaseContextComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext, KoinComponent