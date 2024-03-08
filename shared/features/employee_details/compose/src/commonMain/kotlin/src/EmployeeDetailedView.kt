package src

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.Employee

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeDetailedView(employee: Employee) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.primary,
                    titleContentColor = colorScheme.onPrimary,
                ),
                title = {
                    Text(
                        text = "Rentateam",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 32.sp
                    )
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            tint = colorScheme.onPrimary,
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                EmployeeDetailedCard(employee)
            }
        }
    }
}

@Composable
fun EmployeeDetailedCard(employee: Employee) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Name and Surname
        Text(
            text = employee.firstName + " " + employee.lastName,
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(vertical = 2.dp)
        )

        // Short Bio
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorScheme.primaryContainer)
                .padding(vertical = 8.dp),
        ) {
            Text(
                text = "Android Developer, 3+ years of experience",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = colorScheme.onPrimaryContainer
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {

            // Skills
            Column(
                modifier = Modifier
                    .weight(0.3f, false)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Skills",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                VerticalSkillsList(
                    skills = skillsList
                )
            }

            // Projects
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Projects",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 8.dp, start = 12.dp)
                )

                ProjectList(
                    projects = projectsList
                )
            }
        }
    }
}


@Composable
fun VerticalSkillsList(skills: List<String>) {
    LazyColumn {
        items(skills) { skill ->
            Text(
                text = skill,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
fun ProjectList(projects: List<ProjectCard>) {
    LazyColumn {
        items(projects) { project ->
            ProjectCardItem(project = project)
        }
    }
}

@Composable
fun ProjectCardItem(project: ProjectCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Project name
            Text(
                text = project.projectName,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Company name
            Text(
                text = project.companyName,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Period
            Text(
                text = project.period,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Responsibilities
            Text(
                text = "Responsibilities:\n${project.responsibilities}",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

data class ProjectCard(
    val period: String,
    val companyName: String,
    val projectName: String,
    val responsibilities: String
)

data class EmployeeDetailed(
    val name: String,
    val role: String,
    val technologies: List<String>,
    val phoneNumber: String,
    val email: String,
    val location: String,
    val birthday: String
)

val projectsList = listOf(
    ProjectCard(
        "01.2024 - Present",
        "Company D",
        "Project D",
        "Responsibilities D"
    ),
    ProjectCard(
        "03.2023 - 08.2023",
        "Company C",
        "Project C",
        "Responsibilities C"
    ),
    ProjectCard(
        "09.2022 - 12.2023",
        "Company B",
        "Project B",
        "Responsibilities B"
    ),
    ProjectCard(
        "06.2022 - 10.2022",
        "Company E",
        "Project E",
        "Responsibilities E"
    ),
    ProjectCard(
        "09.2021 - 11.2023",
        "Company A",
        "Project A",
        "Responsibilities A"
    )
)

val skillsList = listOf(
    "Kotlin", "Android SDK", "Android Jetpack",
    "MVVM architecture", "multi-module project",
    "Kotlin coroutines", "Dagger2", "Retrofit",
    "OkHttp", "Gson", "Git", "GitLab",
    "Deep Links", "Push Notifications",
    "Firebase", "AppMetrica"
)

@Composable
fun getSampleEmployee(): EmployeeDetailed {
    return EmployeeDetailed(
        name = "Rick Sanchez",
        role = "Developer",
        technologies = listOf("Kotlin", "Java", "Android"),
        phoneNumber = "+1 123-456-7890",
        email = "rick.pickle@go.com",
        location = "New York, USA",
        birthday = "January 1, 1990"
    )
}