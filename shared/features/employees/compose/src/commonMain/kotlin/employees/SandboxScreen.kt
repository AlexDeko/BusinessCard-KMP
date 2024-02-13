package employees

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import decompose.MviComponent
import decompose.SandboxNavigator
import employees.models.SandboxDefaultState
import employees.models.SandboxEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SandboxScreen(
    component: MviComponent<SandboxDefaultState, SandboxEvent>,
    navigator: SandboxNavigator,
    modifier: Modifier = Modifier
) {
    var textFieldState by remember { mutableStateOf(TextFieldValue()) }
    var checkBoxState by remember { mutableStateOf(false) }
    var switchState by remember { mutableStateOf(false) }
    val radioOptions by remember { mutableStateOf(listOf("Option 1", "Option 2", "Option 3")) }
    var selectedOption by remember { mutableStateOf("Option 1") }
    var sliderPosition by remember { mutableStateOf(0f) }
    var isCardVisible by remember { mutableStateOf(false) }
    var buttonText by remember { mutableStateOf(0) }
    //TODO это не работает с inner padding у scaffold в rootscreen хз почему
    Column(
        modifier = Modifier.padding(
            16.dp,
            16.dp,
            16.dp,
            80.dp
        ).verticalScroll(rememberScrollState())
    ) {
        Text(text = "Hello World", style = TextStyle(fontSize = 20.sp))

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = { buttonText += 1 }) {
            Text("Button clicked $buttonText times")
        }

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(value = textFieldState,
            onValueChange = { textFieldState = it },
            placeholder = { Text("Placeholder") })

        Spacer(modifier = Modifier.padding(10.dp))

        Checkbox(checked = checkBoxState,
            onCheckedChange = { checkBoxState = it })

        Spacer(modifier = Modifier.padding(10.dp))

        Switch(checked = switchState,
            onCheckedChange = { switchState = it })

        Spacer(modifier = Modifier.padding(10.dp))

        radioOptions.map { option ->
            val isSelected = (option == selectedOption)
            Row {
                RadioButton(selected = isSelected,
                    onClick = { selectedOption = option })
                Text(option, Modifier.padding(10.dp))
            }


            Spacer(modifier = Modifier.padding(10.dp))
        }

        OutlinedButton(onClick = {
            isCardVisible = !isCardVisible
        }) {
            Text("Toggle Card visibility")
        }

        AnimatedVisibility(visible = isCardVisible, enter = fadeIn(), exit = fadeOut()) {
            Card(
                shape = ShapeDefaults.ExtraLarge,
                colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                Text("This is a Card", modifier = Modifier.padding(16.dp))
            }
        }

        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f
        )

        Spacer(modifier = Modifier.padding(10.dp))

        CircularProgressIndicator()

        Spacer(modifier = Modifier.padding(10.dp))
    }
}