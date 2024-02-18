package com.card.business.android

import MainView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.retainedComponent
import root.DefaultRootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rc = retainedComponent {
            DefaultRootComponent(
                componentContext = it,
            )
        }

        setContent {
            MainView(component = rc)
        }
    }
}