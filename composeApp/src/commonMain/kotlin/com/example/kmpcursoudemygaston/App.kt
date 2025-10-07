package com.example.kmpcursoudemygaston

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.kmpcursoudemygaston.navigation.AppRoutes
import com.example.kmpcursoudemygaston.navigation.Navigation
import com.example.kmpcursoudemygaston.ui.AppTheme
import com.example.kmpcursoudemygaston.ui.DarkModeColors
import com.example.kmpcursoudemygaston.ui.getColorsTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun App() {
    val colors = getColorsTheme()
    val navController = rememberNavController()
    val title = getCurrentTitle(navController)
    val isHome = getCurrentRouteIsHome(navController)
    AppTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colors.backgroundColor),
            topBar = {
                TopBar(colors, title = title, isHome = isHome, navController = navController)
            },
            floatingActionButton = {
                if (isHome) {
                    FloatingActionButton(
                        modifier = Modifier.padding(8.dp),
                        shape = RoundedCornerShape(50),
                        containerColor = colors.addIconColor,
                        contentColor = Color.White,
                        onClick = {
                            navController.navigate(
                                route = AppRoutes.AddExpense()
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Expense",
                            tint = Color.White
                        )
                    }
                }
            },
            containerColor = colors.backgroundColor,
        ) { innerPadding ->
            Navigation(navController = navController, innerPadding = innerPadding)
        }
    }


}

@Composable
private fun getCurrentTitle(navController: NavHostController): String {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value

    return try {
        when {
            navBackStackEntry?.destination?.route?.contains("Home") == true -> {
                AppRoutes.Home.getTitle()
            }

            navBackStackEntry?.destination?.route?.contains("AddExpense") == true -> {
                val addExpenseRoute = navBackStackEntry.toRoute<AppRoutes.AddExpense>()
                addExpenseRoute.getTitle()
            }

            else -> AppRoutes.Home.getTitle()
        }
    } catch (_: Exception) {
        AppRoutes.Home.getTitle()
    }
}

@Composable
private fun getCurrentRouteIsHome(navController: NavHostController): Boolean {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value

    return try {
        navBackStackEntry?.destination?.route?.contains("Home") == true
    } catch (_: Exception) {
        true
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    colors: DarkModeColors,
    title: String,
    isHome: Boolean,
    navController: NavHostController
) {
    TopAppBar(
        modifier = Modifier
            .background(colors.backgroundColor),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colors.backgroundColor),
        title = {
            Text(text = title, fontSize = 25.sp, color = colors.textColor)
        },
        navigationIcon = {
            if (isHome) {
                HomeNavigationIcon(colors)
            } else {
                BackNavigationIcon(colors, navController)
            }
        }
    )
}

@Composable
private fun HomeNavigationIcon(colors: DarkModeColors) {
    IconButton(
        onClick = {
            // Aquí puedes agregar funcionalidad específica para Home
            // Por ejemplo: abrir drawer, mostrar menú, etc.
        }
    ) {
        Icon(
            imageVector = Icons.Default.Apps,
            tint = colors.textColor,
            contentDescription = "Menu"
        )
    }
}

@Composable
private fun BackNavigationIcon(colors: DarkModeColors, navController: NavHostController) {
    IconButton(
        onClick = {
            navController.popBackStack()
        }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            tint = colors.textColor,
            contentDescription = "Back"
        )
    }
}