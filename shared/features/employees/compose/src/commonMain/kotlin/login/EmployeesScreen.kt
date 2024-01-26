package login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import coroutines.Dispatchers
import dev.icerock.moko.mvvm.compose.viewModelFactory
import extensions.collectAsStateMultiPlatform
import org.koin.compose.getKoin
import org.koin.compose.koinInject
import view_model.State
import widget.ErrorView
import widget.LoadingView

@Composable
fun EmployeeListScreen(
    viewModel: EmployeeViewModel = koinInject()
) {

    when (val state = viewModel.states.collectAsState().value) {
        is State.Success -> {
            EmployeeView(state.data)
        }

        is State.Loading -> {
            LoadingView()
        }

        is State.Error -> {
            ErrorView()
        }
    }
}