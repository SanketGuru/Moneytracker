package com.sanketguru.networth.sqllitedata

import androidx.room.PrimaryKey
import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.ForeignKey
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

//https://regexr.com/
/**
 * Created by sanket.sphere on 29-11-2018.
 */

data class AssetWithPercent(
        @PrimaryKey(autoGenerate = true) var uid: Int,
        @ColumnInfo(name = "_name") var name: String,
        @ColumnInfo(name = "desc") var description: String?,
        @ColumnInfo(name = "value") var value: Double,
        @ColumnInfo(name = "portFolioId") var portFolioId: Int,
        @ColumnInfo(name = "percent") var percent: Float
)
@Entity
data class Asset(
        @PrimaryKey(autoGenerate = true) var uid: Int,
        @ColumnInfo(name = "_name") var name: String,
        @ColumnInfo(name = "desc") var description: String?,
        @ColumnInfo(name = "value") var value: Double,
//        @ForeignKey(
//                entity = PortFolio::class,
//                childColumns = ["portFolioId"],
//                parentColumns = ["uid"],
//                deferred = true,
//                onDelete = ForeignKey.CASCADE
//        )
        @ColumnInfo(name = "portFolioId") var portFolioId: Int=1
)

@Dao
interface AssetDao {
    @Query("SELECT * FROM asset ORDER BY value DESC")
    fun getAll(): List<Asset>

    @Query("select uid, _name, desc, value,portFolioId, (value*100 / (select sum(value) from asset)) as \"percent\" from  asset ")
    fun getAllWithPercent(): List<AssetWithPercent>

    @Query("SELECT * FROM asset WHERE uid IN (:Ids) ")
    fun loadAllByIds(Ids: IntArray): List<Asset>

    @Query("SELECT sum(value) FROM asset WHERE portFolioId == (:portFolioId) ")
    fun getPortFolioValue(portFolioId: Int): Double

    @Query("SELECT * FROM asset WHERE portFolioId == (:portFolioId)  ORDER BY value DESC")
    fun getAssetInPortFolio(portFolioId: Int): List<Asset>

    @Insert
    fun insertAll(vararg data: Asset)

    @Delete
    fun delete(data: Asset): Int

    @Update
    fun update(data: Asset): Int
}

