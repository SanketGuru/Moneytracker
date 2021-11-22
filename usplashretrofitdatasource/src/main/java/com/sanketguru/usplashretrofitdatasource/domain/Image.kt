package com.sanketguru.usplashretrofitdatasource.domain

import com.sanketguru.usplashretrofitdatasource.repo.UnSplashApiHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class Image(val regular: String, val thumb: String)
interface ImageRepo {
    fun images(searchString: String, page: Int): Flow<List<Image>>
}

class ImageRepoImpl(private val api: UnSplashApiHelper) : ImageRepo {
    override fun images(searchString: String, page: Int): Flow<List<Image>> =
        api.searchPhotos(searchString, page)
            .map { a -> a.results.map { Image(it.urls.regular, it.urls.thumb) } }

}