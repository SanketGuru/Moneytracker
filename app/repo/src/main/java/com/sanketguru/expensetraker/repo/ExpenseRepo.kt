package com.sanketguru.expensetraker.repo

import com.sanketguru.expensetraker.data.Expense

interface ExpenseRepo {
    //Basic curd
    fun getExpense( id:Int):Expense
    fun put(data:Expense): Int
    fun delete(id:Int):Boolean
}

