package decompose

import com.arkivanov.decompose.ComponentContext

abstract class ComponentWithNavigation<SuccessState, Event, NavigationChild : Any>(
    componentContext: ComponentContext,
    initialState: State<SuccessState>,
) : MviComponent<SuccessState, Event>(componentContext, initialState), Navigator<NavigationChild>