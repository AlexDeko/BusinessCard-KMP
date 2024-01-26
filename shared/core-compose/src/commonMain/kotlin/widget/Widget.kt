package widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorView() {
    Column(verticalArrangement = Arrangement.Center) {
        Text("Ошибка!")
    }
}

@Composable
fun LoadingView() {
    Column(verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator()
    }
}