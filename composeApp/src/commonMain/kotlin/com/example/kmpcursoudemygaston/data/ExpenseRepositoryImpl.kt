package com.example.kmpcursoudemygaston.data

import com.example.kmpcursoudemygaston.AppDatabase
import com.example.kmpcursoudemygaston.domain.ExpenseRepository
import com.example.kmpcursoudemygaston.domain.model.Expense
import com.example.kmpcursoudemygaston.domain.model.ExpenseCategory

class ExpenseRepositoryImpl(
    private val expenseManager: ExpenseManager,
    private val appDatabase: AppDatabase
) : ExpenseRepository {

    private val queries = appDatabase.expensesDbQueries

    override fun getAllExpenses(): List<Expense> {
        val dbExpenses = queries.selectAll().executeAsList()
        return if (dbExpenses.isNotEmpty()) {
            dbExpenses.map {
                Expense(
                    id = it.id,
                    amount = it.amount,
                    category = ExpenseCategory.valueOf(it.categoryName),
                    description = it.description
                )
            }
        } else {
            emptyList()
        }
    }

    override fun addExpense(expense: Expense) {
        queries.transaction {
            queries.insert(
                amount = expense.amount,
                categoryName = expense.category.name,
                description = expense.description
            )
        }
    }

    override fun updateExpense(expense: Expense) {
        queries.transaction {
            queries.update(
                id = expense.id,
                amount = expense.amount,
                categoryName = expense.category.name,
                description = expense.description
            )
        }
    }

    override fun deleteExpense(expense: Expense) {
        queries.transaction {
            queries.delete(expense.id)
        }
    }

    override fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }
}