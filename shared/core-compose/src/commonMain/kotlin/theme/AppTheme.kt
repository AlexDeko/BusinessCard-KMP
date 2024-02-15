package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApplicationTheme(
    customTheme: BusinessCardAppTheme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = when (customTheme) {
        is BusinessCardAppTheme.ChristmasTheme -> {
            lightColorScheme(
                primary = Color(0xFFEE0010),
                secondary = Color(0xFFFF9407),
                tertiary = Color(0xFF020007)
            )
        }
        is BusinessCardAppTheme.LightTheme -> {
            lightColorScheme(
                primary = Color(0xFF6200EE),
                secondary = Color(0xFF03DAC5),
                tertiary = Color(0xFF3700B3)
            )
        }
        is BusinessCardAppTheme.DarkTheme -> {
            darkColorScheme(
                primary = Color(0xFFBB86FC),
                secondary = Color(0xFF03DAC5),
                tertiary = Color(0xFF3700B3)
            )
        }
        is BusinessCardAppTheme.RentateamTheme -> {
            lightColorScheme(
                primary = Color(0xFF0A1D86),
                onPrimary = Color(0xFFF6FBFA),
                tertiary = Color(0xFF0C0C0C),
                primaryContainer = Color(0xFFE9DCEB)
            )
        }
    }

    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

sealed class BusinessCardAppTheme {
    data object DarkTheme : BusinessCardAppTheme()
    data object ChristmasTheme: BusinessCardAppTheme()
    data object LightTheme: BusinessCardAppTheme()
    data object RentateamTheme: BusinessCardAppTheme()
}