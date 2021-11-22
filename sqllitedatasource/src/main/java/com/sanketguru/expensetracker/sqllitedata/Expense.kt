package com.sanketguru.expensetracker.sqllitedata

import androidx.room.*
//https://apipheny.io/free-api/

/***
 *Expense
 */
@Entity
public data class Expense(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val name: String,
    val amount: Double,
    val time: Long,
    val tagList: String,
    val category: String,
    val note: String?,
    val isPaid: Boolean,
    val paymentMethod: PaymentMethod
)

@Dao
interface ExpenseDoa {
    @Query("SELECT * FROM expense WHERE uid IN (:ids) ")
    suspend fun getExpense(ids: IntArray): List<Expense>

    @Insert
    suspend fun insertAll(vararg data: Expense)

    @Delete
    suspend fun delete(data: Expense): Int

    @Update
    suspend fun update(data: Expense): Int

    @Query("SELECT * FROM expense WHERE time BETWEEN :from AND :to")
    suspend fun getExpenseBetween(from: Long,to: Long): List<Expense>

    @Query("SELECT * FROM expense WHERE category =:category AND time BETWEEN :from AND :to ")
    suspend fun getExpenseBetweenAndCategory(from: Long,to: Long,category:String): List<Expense>
}