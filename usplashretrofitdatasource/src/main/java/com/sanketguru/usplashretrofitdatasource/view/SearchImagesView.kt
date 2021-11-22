package com.sanketguru.usplashretrofitdatasource.view

import android.util.Log
import com.sanketguru.usplashretrofitdatasource.domain.Image
import com.sanketguru.usplashretrofitdatasource.domain.ImageRepo
import com.sanketguru.usplashretrofitdatasource.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

interface SearchImagesView {
    fun search():Flow<String>
    fun render(data:Resource<List<Image>>)
}
class SearchImagesModel(private val view:SearchImagesView, private val repo:ImageRepo){
     fun setUp(){
         MainScope().launch {
             view.search().debounce(300)
                 .filter { query ->
                     return@filter !query.isEmpty()
                 }.distinctUntilChanged().onStart {
                     view.render(Resource.loading(null))
                 }
                 .flatMapLatest { query ->
                     repo.images(query,40)
                         .catch {
                             // emitAll(flowOf(""))
                             view.render(Resource.error("problem",null))
                         }
                 }
                 .flowOn(Dispatchers.Default)
                 .collect { result ->
                     view.render(Resource.success(result))
                     // textViewResult.text = result
                 }

         }

    }

}