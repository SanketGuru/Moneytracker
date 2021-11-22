package com.sanketguru.usplashretrofitdatasource.repo

import com.sanketguru.usplashretrofitdatasource.data.ImageListWrapper
import kotlinx.coroutines.flow.flow

class UnSplashApiHelperImpl (private val apiService: UnSplashApiService) : UnSplashApiHelper{
    override fun searchPhotos(query: String, prePage: Int) = flow { emit(apiService.searchPhotos(query,prePage,RetrofitBuilder.CLIENT_ID)) }
}