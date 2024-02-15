package widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorView(text: String = "Ошибка!") {
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = text)
    }
}

@Composable
fun LoadingView() {
    Column(verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator()
    }
}