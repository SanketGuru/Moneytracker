package com.sanketguru.networth.domain.data

data class Asset(
    var uid: Int,
    var name: String,
    var description: String?,
     var value: Double
)