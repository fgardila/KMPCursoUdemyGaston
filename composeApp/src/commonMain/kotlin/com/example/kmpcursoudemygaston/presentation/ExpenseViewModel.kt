package com.example.kmpcursoudemygaston.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpcursoudemygaston.domain.ExpenseRepository
import com.example.kmpcursoudemygaston.domain.model.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ExpensesUiState(
    val expenses: List<Expense> = emptyList(),
    val totalAmount: Double = 0.0,
    val isLoading: Boolean = false,
    val error: String? = null
)

class ExpenseViewModel(private val repo: ExpenseRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(ExpensesUiState())
    val uiState = _uiState.asStateFlow()
    private var allExpenses: MutableList<Expense> = mutableListOf()

    private val categories = repo.getCategories()

    init {
        getAllExpenses()
    }

    private fun updateExpenseList() {
        viewModelScope.launch {
            allExpenses = repo.getAllExpenses().toMutableList()
            updateState()
        }
    }


    private fun updateState() {
        _uiState.update { state ->
            state.copy(expenses = allExpenses, totalAmount = allExpenses.sumOf { it.amount })
        }
    }

    fun getAllExpenses() {
        repo.getAllExpenses()
        updateExpenseList()

    }

    fun addExpense(expense: Expense) {
        repo.addExpense(expense)
        updateExpenseList()
    }

    fun editExpense(expense: Expense) {
        repo.updateExpense(expense)
        updateExpenseList()
    }

    fun deleteExpense(expense: Expense) {
        repo.deleteExpense(expense)
        updateExpenseList()
    }

    fun getExpenseWithId(id: Long): Expense? {
        return allExpenses.find { it.id == id }
    }

    fun getCategories() = repo.getCategories()
}