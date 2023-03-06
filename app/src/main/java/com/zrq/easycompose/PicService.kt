package com.zrq.easycompose

import com.zrq.easycompose.bean.Category
import retrofit2.Call
import retrofit2.http.GET

interface PicService {

    @GET("category?adult=true&first=1")
    fun getCategory(): Call<Category>
}