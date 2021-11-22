package com.sanketguru.networth.domain.data

data class Liability(
    val uid: Int,
    val name: String,
    val desc: String,
    val emi: Double,
    val noOfEmi: Int,
    val dateOfMonth: Short,
    val calculateInGrand: Boolean
)