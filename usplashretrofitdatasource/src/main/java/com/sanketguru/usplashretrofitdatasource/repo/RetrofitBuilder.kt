package com.sanketguru.usplashretrofitdatasource.repo

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.unsplash.com/"
    internal const val CLIENT_ID = "3LG8LwNcmXYZQCpIMqCw93I"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val apiService: UnSplashApiService = getRetrofit().create(UnSplashApiService::class.java)

}