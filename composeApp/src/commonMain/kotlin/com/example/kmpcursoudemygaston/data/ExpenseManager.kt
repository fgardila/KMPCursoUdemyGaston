package com.example.kmpcursoudemygaston.data

import com.example.kmpcursoudemygaston.domain.model.Expense
import com.example.kmpcursoudemygaston.domain.model.ExpenseCategory

object ExpenseManager {
    private var currentId = 1L
    val fakeExpenseList = mutableListOf<Expense>(
        Expense(
            id = currentId++,
            amount = 50.0,
            category = ExpenseCategory.GROCERIES,
            description = "Supermarket"
        ),
        Expense(
            id = currentId++,
            amount = 20.0,
            category = ExpenseCategory.TRANSPORT,
            description = "Bus ticket"
        ),
        Expense(
            id = currentId++,
            amount = 15.5,
            category = ExpenseCategory.SNACKS,
            description = "Lunch"
        ),
        Expense(
            id = currentId++,
            amount = 100.0,
            category = ExpenseCategory.PARTY,
            description = "Concert"
        ),
        Expense(
            id = currentId++,
            amount = 5.0,
            category = ExpenseCategory.COFFEE,
            description = "Coffee"
        ),
        Expense(
            id = currentId++,
            amount = 200.0,
            category = ExpenseCategory.HOUSE,
            description = "Rent"
        ),
        Expense(
            id = currentId++,
            amount = 30.0,
            category = ExpenseCategory.OTHER,
            description = "Miscellaneous"
        )
    )

    fun addNewExpense(expense: Expense) {
        val expenseWithId = expense.copy(id = currentId++)
        fakeExpenseList.add(expenseWithId)
    }

    fun editExpense(expense: Expense) {
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun getCategories(): List<ExpenseCategory> = ExpenseCategory.entries
}