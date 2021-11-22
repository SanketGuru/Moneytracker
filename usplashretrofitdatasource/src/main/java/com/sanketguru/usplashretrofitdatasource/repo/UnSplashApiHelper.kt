package com.sanketguru.usplashretrofitdatasource.repo

import com.sanketguru.usplashretrofitdatasource.data.ImageListWrapper
import kotlinx.coroutines.flow.Flow

interface UnSplashApiHelper {
    fun searchPhotos(
        query: String,
        prePage: Int
    ): Flow<ImageListWrapper>
}