package com.card.business.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import root.DefaultRootComponent
import root.RootBottomScreen
import theme.BusinessCardAppTheme
import theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent = DefaultRootComponent(
            componentContext = defaultComponentContext(),
        )

        setContent {
            MyApplicationTheme(customTheme = BusinessCardAppTheme.RentateamTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    setContent {
                        RootBottomScreen(rootComponent)
                    }
                }
            }
        }
    }
}