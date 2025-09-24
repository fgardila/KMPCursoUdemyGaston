package com.example.kmpcursoudemygaston

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kmpcursoudemygaston.ui.AppTheme
import com.example.kmpcursoudemygaston.ui.getColorsTheme
import moe.tlaster.precompose.PreComposeApp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun App() {
    PreComposeApp {

        val colors = getColorsTheme()

        AppTheme {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Bienvenidos")
                Text("Curso de Android y iOS con Kotlin Multiplatform")
            }
        }
    }
}