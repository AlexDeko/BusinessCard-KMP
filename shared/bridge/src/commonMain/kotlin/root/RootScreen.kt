package root

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import employees.EmployeeListScreen

data class ScreensBottom(val name: String, val openScreen: () -> Unit, val isSelected: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootBottomScreen(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val screens by remember {
        mutableStateOf(
            listOf(
                ScreensBottom("ListEmployees", component::openListEmployees, false),
                //TODO create second tab
                //ScreensBottom("AboutCompany", component::openAboutCompany, false),
            )
        )
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                actions = {
                    screens.forEachIndexed { index, screensBottom ->
                        NavigationBarItem(
                            icon = {
                                when (screensBottom.name) {
                                    "ListEmployees" -> Icon(
                                        Icons.Outlined.Home,
                                        contentDescription = null
                                    )
                                }
                            },
                            label = {
                                Text(
                                    text = screensBottom.name,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Light
                                )
                            },
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                screensBottom.openScreen()
                            },
                            colors = NavigationBarItemDefaults.colors(selectedIconColor = MaterialTheme.colorScheme.primary)
                        )
                    }
                }
            )

        },
        content = { innerpadding ->
            Column(modifier = Modifier.padding(innerpadding)) {
                Children(
                    stack = component.childStackBottom,
                    modifier = modifier,
                    animation = stackAnimation(fade() + scale()),
                ) {
                    when (val child = it.instance) {
                        is RootComponent.ChildBottom.EmployeesListChild -> EmployeeListScreen(
                            component = child.component
                        )
                    }
                }
            }
        })


}