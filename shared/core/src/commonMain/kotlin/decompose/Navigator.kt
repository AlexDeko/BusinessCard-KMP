package decompose

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner

interface Navigator<NavigationChild : Any> : BackHandlerOwner {

    val childStackNavigation: Value<ChildStack<*, NavigationChild>>

    fun backClickedEvent() {}
}