package com.sanketguru.expensetraker.repo

import com.sanketguru.networth.data.Asset

interface AssetRepo {
    //Basic curd
    fun getAsset( id:Int): Asset
    fun put(data: Asset): Int
    fun delete(id:Int):Boolean
}