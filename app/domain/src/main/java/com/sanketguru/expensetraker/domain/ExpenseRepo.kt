package com.sanketguru.expensetraker.domain

import com.sanketguru.expensetraker.domain.data.Expense

interface ExpenseRepo {
    //Basic curd
    fun getExpense( id:Int): Expense
    fun put(data: Expense): Int
    fun delete(id:Int):Boolean
}

