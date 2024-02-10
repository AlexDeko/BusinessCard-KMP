package decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import coroutines.coroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent


/**
 * State - сотояние экрана; которое обновляется после события [Event]
 *  1) Ввели текст в поле ввода
 *  2) Отправили [State] в composable function, чтобы сделать кнопку сохранить доступной для нажатия
 *
 * Event - события, которые нам шлёт composable function
 * Например, клики на кнопки
 *
 * Action - действия на послаемые события [Event];
 * В мире Андроида можно воспринить как SingleLiveEvent
 * Например,
 * 1) Нажали на кнопку, сохранили данные в базе данных,
 * 2) Отправили [Action] в composable function, произошла навигация в другую composable function
 *
 * -------------------------------------------------------------------------------------------------
 *
 * State и Action разделены, чтобы рекомпозиция была эффективнее
 * И разделить отрисовку экрана и навгицию
 *
 */
abstract class MviComponent<SuccessState, Event>(
    componentContext: ComponentContext,
    private val initialState: State<SuccessState>,
) : ComponentContext by componentContext, KoinComponent {

    protected val componentScope = coroutineScope

    private val mutableStates = MutableStateFlow(initialState)

    val states = mutableStates.asStateFlow()

    protected fun pushState(state: State<SuccessState>) {
        mutableStates.value = state
    }

    abstract fun obtainEvent(event: Event)

    init {
        lifecycle.doOnDestroy {
            componentScope.cancel()
        }
    }
}

sealed interface State<out T> {

    object Loading : State<Nothing>

    data class Error(val throwable: Throwable) : State<Nothing>

    data class Success<T>(val data: T) : State<T>
}