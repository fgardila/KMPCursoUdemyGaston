package com.example.kmpcursoudemygaston.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.kmpcursoudemygaston.data.ExpenseManager
import com.example.kmpcursoudemygaston.data.ExpenseRepositoryImpl
import com.example.kmpcursoudemygaston.presentation.ExpenseViewModel
import com.example.kmpcursoudemygaston.ui.ExpenseDetailScreen
import com.example.kmpcursoudemygaston.ui.ExpensesScreen
import com.example.kmpcursoudemygaston.ui.getColorsTheme

@Composable
fun Navigation(navController: NavHostController, innerPadding: PaddingValues) {

    val colors = getColorsTheme()

    val viewModel = viewModel {
        ExpenseViewModel(repo = ExpenseRepositoryImpl(ExpenseManager))
    }

    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = Modifier
            .background(colors.backgroundColor)
            .padding(innerPadding)
    ) {

        composable<Home> {

            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            ExpensesScreen(
                uiState = uiState,
                onExpenseClick = { expense ->
                    navController.navigate(
                        route = AddExpense(expenseId = expense.id)
                    )
                }
            )
        }

        composable<AddExpense> { backStackEntry ->

            val addExpenseRoute = backStackEntry.toRoute<AddExpense>()
            val expenseId = addExpenseRoute.expenseId

            val isAddExpense = expenseId?.let { id -> viewModel.getExpenseWithId(id) }

            ExpenseDetailScreen(
                expenseToEdit = isAddExpense,
                categoryList = viewModel.getCategories()
            ) { expense ->
                if (isAddExpense == null) {
                    viewModel.addExpense(expense)
                } else {
                    viewModel.editExpense(expense)
                }
                navController.popBackStack()
            }
        }

    }
}
