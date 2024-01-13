package com.card.business.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme(customTheme = BusinessCardAppTheme.RentateamTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    EmployeeListScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeListScreen(
//    employeeRepository: EmployeeRepository = EmployeeRepositoryImpl(Api(), SqlDelightStorage())
) {

    var expandedCardIndex by remember { mutableStateOf(-1) }

    val employees = listOf(
        Employee(1, "John", "Doe", JobEnum.DEVELOPER),
        Employee(2, "Jane", "Smith", JobEnum.PROJECT_MANAGER),
        Employee(3, "Bill", "Cipher", JobEnum.QA),
        Employee(4, "Santa", "Claus", JobEnum.CEO),
    )

//    val employees = remember { employeeRepository.listenEmployees() }

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
                            painter = painterResource(R.drawable.ic_filter_white),
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
            EmployeeList(employees, expandedCardIndex) { index ->
                expandedCardIndex = if (expandedCardIndex == index) -1 else index
            }
        }
    }
}

@Composable
fun EmployeeList(
    employees: List<Employee>,
    expandedCardIndex: Int,
    onEmployeeClick: (Int) -> Unit
) {
    LazyColumn {
        items(employees) { employee ->
            EmployeeCard(employee, expandedCardIndex == employees.indexOf(employee)) {
                onEmployeeClick(employees.indexOf(employee))
            }
        }
    }
}

@Composable
fun EmployeeCard(employee: Employee, isExpanded: Boolean, onCardClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 16.dp, 20.dp, 8.dp)
            .clickable { onCardClick() },
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
                    text = employee.position.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Preview
@Composable
fun EmployeesListPreview() {
    MyApplicationTheme(customTheme = BusinessCardAppTheme.RentateamTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            EmployeeListScreen()
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme(customTheme = BusinessCardAppTheme.ChristmasTheme) {
        GreetingView("Hello, Android!")
    }
}

data class Employee(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val position: JobEnum
)

enum class JobEnum {
    DEVELOPER, QA, PROJECT_MANAGER, CEO
}