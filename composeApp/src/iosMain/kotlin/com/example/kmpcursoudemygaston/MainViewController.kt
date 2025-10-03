package com.example.kmpcursoudemygaston

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmpcursoudemygaston.di.appModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { App() }

fun initKoin() {
    startKoin {
        modules(appModule())
    }.koin
}