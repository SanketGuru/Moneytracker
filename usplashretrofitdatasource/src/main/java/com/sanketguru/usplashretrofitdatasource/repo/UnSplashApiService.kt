package com.sanketguru.usplashretrofitdatasource.repo

import com.sanketguru.usplashretrofitdatasource.data.ImageListWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface UnSplashApiService {
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("per_page") prePage: Int,
        @Query("client_id") clientId: String
    ): ImageListWrapper
}