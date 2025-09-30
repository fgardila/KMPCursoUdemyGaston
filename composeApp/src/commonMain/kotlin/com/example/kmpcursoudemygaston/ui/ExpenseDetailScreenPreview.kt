package com.example.kmpcursoudemygaston.ui

import androidx.compose.runtime.Composable
import com.example.kmpcursoudemygaston.domain.model.Expense
import com.example.kmpcursoudemygaston.domain.model.ExpenseCategory
import org.jetbrains.compose.ui.tooling.preview.Preview

val fakeExpense = Expense(
    id = 1L,
    amount = 25.50,
    category = ExpenseCategory.GROCERIES,
    description = "Compra de supermercado"
)

val fakeCategoryList = listOf(
    ExpenseCategory.GROCERIES,
    ExpenseCategory.TRANSPORT,
    ExpenseCategory.SNACKS,
    ExpenseCategory.PARTY,
    ExpenseCategory.COFFEE,
    ExpenseCategory.HOUSE,
    ExpenseCategory.OTHER
)

@Preview(showBackground = true)
@Composable
fun PreviewExpenseAmount() {
    ExpenseAmount(
        priceContent = fakeExpense.amount,
        keyboardController = null,
        onPriceChange = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewExpenseTypeSelector() {
    ExpenseTypeSelector(
        categorySelected = fakeExpense.category.name,
        openBottomSheet = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewExpenseDescription() {
    ExpenseDescription(
        descriptionContent = fakeExpense.description,
        onDescriptionChange = {},
        keyboardController = null
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewExpenseDetailScreen() {
    ExpenseDetailScreen(
        expenseToEdit = fakeExpense,
        categoryList = fakeCategoryList,
        addExpenseAndNavigateBack = {}
    )
}
