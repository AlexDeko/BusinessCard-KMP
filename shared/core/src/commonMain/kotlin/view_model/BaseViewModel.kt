package view_model

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow


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
abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) : ViewModel() {

    private val mutableStates = MutableStateFlow(initialState)

    private val mutableActions = MutableSharedFlow<Action>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val states = mutableStates.asStateFlow()

    val actions = mutableActions.asSharedFlow()

    protected fun pushState(state: State) {
        mutableStates.value = state
    }

    protected fun pushAction(action: Action) = mutableActions.tryEmit(action)

    abstract fun obtainEvent(event: Event)
}