package decompose

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface Navigator<NavigationChild : Any> {

    val childStackNavigation: Value<ChildStack<*, NavigationChild>>
}