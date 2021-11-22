package com.sanketguru.expensetraker.domain

import com.sanketguru.expensetraker.domain.data.Category
import com.sanketguru.expensetraker.domain.data.Expense
import java.util.Date

interface ExpenseFilterRepo{
    fun getExpenseBetween(from: Date, to: Date):List<Expense>
    fun getExpenseCategory(from: Date, to: Date, category: Category):List<Expense>
}