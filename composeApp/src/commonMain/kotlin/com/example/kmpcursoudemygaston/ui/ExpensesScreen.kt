package com.example.kmpcursoudemygaston.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmpcursoudemygaston.data.ExpenseManager
import com.example.kmpcursoudemygaston.domain.model.Expense
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ExpensesScreen(
    onExpenseClick: (Expense) -> Unit
) {
    val color = getColorsTheme()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        stickyHeader {
            Column(
                modifier = Modifier.background(color = color.backgroundColor)
            ) {
                ExpensesTotalHeader(1234.56)
                AllExpensesHeader()
            }
        }

        items(ExpenseManager.fakeExpenseList) {
            ExpensesItem(expense = it, onExpenseClick = { expense ->
                onExpenseClick(expense)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpensesScreenPreview() {
    ExpensesScreen(onExpenseClick = {})
}

@Composable
fun ExpensesTotalHeader(totalAmount: Double) {
    Card(
        shape = RoundedCornerShape(30),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(Color.Black),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "$$totalAmount",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = "USD",
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpensesTotalHeaderPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        ExpensesTotalHeader(totalAmount = 1234.56)
    }
}

@Composable
fun AllExpensesHeader() {
    val color = getColorsTheme()

    Row(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "All Expenses",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = color.textColor,
            modifier = Modifier.padding(vertical = 8.dp).weight(1f)
        )

        Button(
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
            modifier = Modifier
                .align(Alignment.CenterVertically),
            onClick = { /* TODO */ }
        ) {
            Text(text = "View All", color = color.textColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllExpensesHeaderPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        AllExpensesHeader()
    }
}

@Composable
fun ExpensesItem(expense: Expense, onExpenseClick: (Expense) -> Unit) {
    val color = getColorsTheme()

    Card(
        shape = RoundedCornerShape(30),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(color.colorExpenseItem),
        modifier = Modifier
            .clickable { onExpenseClick(expense) }
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(35),
                color = color.purple
            ) {
                Image(
                    modifier = Modifier.padding(10.dp),
                    imageVector = expense.icon,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Icon Expense"
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = expense.category.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = color.textColor
                )
                Text(
                    text = expense.description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Gray
                )
            }
            Text(
                text = "$${expense.amount}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = color.textColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpensesItemPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        ExpensesItem(
            expense = ExpenseManager.fakeExpenseList[0],
            onExpenseClick = {}
        )
    }
}