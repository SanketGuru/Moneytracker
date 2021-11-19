package com.sanketguru.expensetraker.repo

import com.sanketguru.expensetraker.data.Category
import com.sanketguru.expensetraker.data.Expense
import java.util.Date

interface ExpenseFilterRepo{
    fun getExpenseBetween(from: Date, to: Date):List<Expense>
    fun getExpenseCategory(from: Date, to: Date, category: Category):List<Expense>
}