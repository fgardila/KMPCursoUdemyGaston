package com.example.kmpcursoudemygaston.di

import com.example.kmpcursoudemygaston.data.ExpenseManager
import com.example.kmpcursoudemygaston.data.ExpenseRepositoryImpl
import com.example.kmpcursoudemygaston.domain.ExpenseRepository
import com.example.kmpcursoudemygaston.presentation.ExpenseViewModel
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

fun appModule() = module {
    single { ExpenseManager }.withOptions { createdAtStart() }
    single<ExpenseRepository> { ExpenseRepositoryImpl(get()) }
    factory { ExpenseViewModel(get()) }
}