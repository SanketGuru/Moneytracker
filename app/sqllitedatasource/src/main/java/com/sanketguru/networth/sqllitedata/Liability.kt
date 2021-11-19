package com.sanketguru.networth.sqllitedata

import androidx.room.*

/**
 * Created by sanket.sphere on 31-12-2018.
 */
@Entity
data class Liability(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "_name") val name: String,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "value") val emi: Double,
    @ColumnInfo(name = "noEmi") val noOfEmi: Int,
    @ColumnInfo(name = "dueDate") val dateOfMonth: Short,
    @ColumnInfo(name = "calculate") val calculateInGrand: Boolean
) {

    private fun isEmi(): Boolean = noOfEmi > 1

    fun value(): Double = if (isEmi()) {
        emi * noOfEmi
    } else emi


}

@Dao
interface LiabilityDao {
    @Query("SELECT * FROM liability")
    fun getAll(): List<Liability>

    @Query("SELECT * FROM liability WHERE uid IN (:userIds) ")
    fun loadAllByIds(userIds: IntArray): List<Liability>

    @Insert
    fun insertAll(vararg users: Liability)

    @Delete
    fun delete(user: Liability): Int

    @Update
    fun update(asset: Liability): Int
}