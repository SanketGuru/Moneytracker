package com.sanketguru.networth.domain

import com.sanketguru.networth.domain.data.Asset

interface AssetRepo {
    //Basic curd
    fun getAsset( id:Int): Asset
    fun put(data: Asset): Int
    fun delete(id:Int):Boolean
}