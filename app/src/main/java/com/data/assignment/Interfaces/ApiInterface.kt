package com.retrofit1.Interfaces

import com.data.assignment.Model.ImageUpload
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("r/images/hot.json")
    fun getProjectList(): Call<ImageUpload>
}