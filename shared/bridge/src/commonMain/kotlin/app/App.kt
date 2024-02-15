package app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import root.RootBottomScreen
import root.RootComponent
import theme.BusinessCardAppTheme
import theme.MyApplicationTheme

@Composable
fun App(rootComponent: RootComponent, modifier: Modifier = Modifier) {
    MyApplicationTheme(customTheme = BusinessCardAppTheme.RentateamTheme) {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            RootBottomScreen(rootComponent)
        }
    }
}