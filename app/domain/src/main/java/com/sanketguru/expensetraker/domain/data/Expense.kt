package com.sanketguru.expensetraker.domain.data

import java.util.Date;

/***
 *Expense
 */
public data class Expense (
    val id:Int,
    val name:String,
    val amount: Double,
    val time:Date,
    val tagList:List<Tag>?,
    val category:Category,
    val note:String?,
    val isPaid:Boolean,
    val paymentMethod:String
    )