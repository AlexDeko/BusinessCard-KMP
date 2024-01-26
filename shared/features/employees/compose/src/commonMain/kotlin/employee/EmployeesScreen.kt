package employee

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.koinInject
import view_model.State
import widget.ErrorView
import widget.LoadingView

@Composable
fun EmployeeListScreen(
    viewModel: EmployeeListViewModel = koinInject()
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