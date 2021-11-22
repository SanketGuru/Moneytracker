package com.sanketguru.usplashretrofitdatasource.data

import com.squareup.moshi.Json

data class ImageListWrapper(val total: Int, @Json(name = "total_pages") val totalPages: Int, val results: List<ImageDetails>)

