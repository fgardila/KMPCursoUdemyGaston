package com.example.kmpcursoudemygaston

import android.app.Application
import com.example.kmpcursoudemygaston.data.DatabaseDriverFactory
import com.example.kmpcursoudemygaston.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(
                appModule,
                // Módulo específico de Android
                module {
                    single {
                        AppDatabase.invoke(
                            driver = DatabaseDriverFactory(
                                context = this@MainApplication
                            ).createDriver()
                        )
                    }
                }
            )
        }
    }
}