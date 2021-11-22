package com.sanketguru.sqllitedata


import androidx.room.Database
import androidx.room.RoomDatabase
import com.sanketguru.expensetracker.sqllitedata.Expense
import com.sanketguru.networth.sqllitedata.*

/**
 * Created by sanket.sphere on 12-12-2018.
 */
@Database(
    entities = [
        Asset::class,
        PortFolio::class,
        Liability::class,
        Expense::class
    ],
    version = 0,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun assetDao(): AssetDao
    abstract fun portfolioDao(): PortfolioDao
    abstract fun liabilityDao(): LiabilityDao
    abstract fun expenseDao(): Expense
}