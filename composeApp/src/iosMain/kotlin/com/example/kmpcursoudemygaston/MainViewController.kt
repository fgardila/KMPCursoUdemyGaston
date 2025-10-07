package com.example.kmpcursoudemygaston

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmpcursoudemygaston.data.DatabaseDriverFactory
import com.example.kmpcursoudemygaston.di.appModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun MainViewController() = ComposeUIViewController { App() }

fun initKoin() {
    startKoin {
        modules(
            appModule, appModule,
            // Módulo específico de iOS
            module {
                single {
                    AppDatabase.invoke(
                        driver = DatabaseDriverFactory().createDriver()
                    )
                }
            }
        )
    }.koin
}