package com.example.kmpcursoudemygaston.navigation

import kotlinx.serialization.Serializable

/**
 * Sealed class que agrupa todas las rutas de navegación de la aplicación.
 * Usar @Serializable permite type-safe navigation con parámetros.
 *
 * Ventajas de usar sealed class:
 * - Mejor organización y agrupación
 * - Facilita when expressions exhaustivas
 * - Escalabilidad para proyectos grandes
 * - Namespace claro para las rutas
 */
@Serializable
sealed class AppRoutes {

    @Serializable
    data object Home : AppRoutes()

    @Serializable
    data class AddExpense(val expenseId: Long? = null) : AppRoutes()

    /**
     * Devuelve el título asociado a cada ruta para el TopBar
     */
    fun getTitle(): String = when (this) {
        is Home -> "Dashboard"
        is AddExpense -> if (expenseId == null) "Add a new Expense" else "Edit Expense"
        // Agregar aquí futuros títulos para nuevas rutas
    }

    // Futuras rutas se pueden agregar aquí:
    // @Serializable
    // data object Settings : AppRoutes()
    //
    // @Serializable
    // data class ExpenseDetail(val expenseId: Long) : AppRoutes()
    //
    // @Serializable
    // data class Profile(val userId: String) : AppRoutes()
}

// Type aliases para facilitar el uso (opcional)
typealias Home = AppRoutes.Home
typealias AddExpense = AppRoutes.AddExpense
