package employees

import EmployeeDetailedView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import decompose.EmployeeListNavigator
import decompose.MviComponent
import decompose.State
import employees.models.EmployeesDataState
import employees.models.EmployeesEvent
import extensions.observeAsState
import models.Employee
import widget.ErrorView
import widget.LoadingView

@Composable
fun EmployeeListScreen(
    component: MviComponent<EmployeesDataState, EmployeesEvent>,
    navigator: EmployeeListNavigator,
    modifier: Modifier = Modifier
) {
    val state = component.states.observeAsState()

    Children(
        stack = navigator.childStackNavigation,
        modifier = modifier,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is EmployeeListNavigator.Child.EmployeesListChild -> EmployeesView(
                state = state.value,
                eventHandler = component::obtainEvent
            )

            is EmployeeListNavigator.Child.DetailsEmployeeChild -> EmployeeDetailedView(
                employee = child.employee
            )
        }
    }
}

@Composable
fun EmployeesView(
    state: State<EmployeesDataState>,
    eventHandler: (EmployeesEvent) -> Unit
) {

    when (state) {
        is State.Success -> {
            SuccessStateEmployees(state.data.employees, eventHandler)
        }

        is State.Loading -> {
            LoadingView()
        }

        is State.Error -> {
            ErrorView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuccessStateEmployees(
    employees: List<Employee>,
    eventHandler: (EmployeesEvent) -> Unit,
) {
    val expandedCardIndex = remember { mutableStateOf(-1) }


    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                title = {
                    Text(
                        "Rentateam",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 32.sp
                    )
                },
                //TODO добавить, если потребуется
//                navigationIcon = {
//                    IconButton(onClick = { /* do something */ }) {
//                        Icon(
//                            imageVector = Icons.Filled.ArrowBack,
//                            contentDescription = "Localized description"
//                        )
//                    }
//                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            EmployeeList(employees, expandedCardIndex.value, { index ->
                eventHandler(
                    EmployeesEvent.ClickEmployees(
                        employee = employees[index]
                    )
                )
            }, { index ->
                expandedCardIndex.value = index
            })
        }
    }
}

@Composable
fun EmployeeList(
    employees: List<Employee>,
    expandedCardIndex: Int,
    onEmployeeClick: (Int) -> Unit,
    onEmployeeLongClick: (Int) -> Unit
) {
    LazyColumn {
        items(employees) { employee ->
            EmployeeCard(
                employees.indexOf(employee),
                employee,
                expandedCardIndex == employees.indexOf(employee),
                {
                    onEmployeeClick(employees.indexOf(employee))
                }, {
                    onEmployeeLongClick(employees.indexOf(employee))
                })
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EmployeeCard(
    position: Int,
    employee: Employee,
    isExpanded: Boolean,
    onCardClick: () -> Unit,
    onCardLongClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 16.dp, 20.dp, 8.dp)
            .combinedClickable(onLongClick = onCardLongClick, onClick = onCardClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.onBackground,
            disabledContentColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = employee.firstName + " " + employee.lastName,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = position.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}