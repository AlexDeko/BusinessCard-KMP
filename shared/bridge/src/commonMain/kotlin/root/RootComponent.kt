package root

import about.AboutComponent
import buy.BuyComponent
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import home.HomeComponent
import notifications.NotificationComponent


interface RootComponent {
    val childStackBottom: Value<ChildStack<*, ChildBottom>>
    fun openListEmployees())

    sealed class ChildBottom {
        class WelcomeChild(val component: HomeComponent) : ChildBottom()
        class FeedsChild(val component: BuyComponent) : ChildBottom()
        class MessageChild(val component: AboutComponent) : ChildBottom()
        class NotificationsChild(val component: NotificationComponent) : ChildBottom()
    }


}