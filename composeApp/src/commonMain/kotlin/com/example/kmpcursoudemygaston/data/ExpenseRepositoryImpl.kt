package com.example.kmpcursoudemygaston.data

import com.example.kmpcursoudemygaston.domain.ExpenseRepository
import com.example.kmpcursoudemygaston.domain.model.Expense
import com.example.kmpcursoudemygaston.domain.model.ExpenseCategory

class ExpenseRepositoryImpl : ExpenseRepository {
    override fun getAllExpenses(): List<Expense> {
        return ExpenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
        ExpenseManager.addNewExpense(expense)
    }

    override fun updateExpense(expense: Expense) {
        ExpenseManager.editExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return ExpenseManager.getCategories()
    }
}