package com.example.kmpcursoudemygaston.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.ElectricCar
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.PartyMode
import androidx.compose.material.icons.filled.ViewCozy
import androidx.compose.ui.graphics.vector.ImageVector

data class Expense(
    val id: Long = -1,
    val amount: Double,
    val category: ExpenseCategory,
    val description: String
) {
    val icon = category.icon
}

enum class ExpenseCategory(val icon: ImageVector) {
    GROCERIES(icon = Icons.Default.FoodBank),
    TRANSPORT(icon = Icons.Default.ElectricCar),
    SNACKS(icon = Icons.Default.Fastfood),
    PARTY(icon = Icons.Default.PartyMode),
    COFFEE(icon = Icons.Default.Coffee),
    HOUSE(icon = Icons.Default.House),
    OTHER(icon = Icons.Default.ViewCozy)
}