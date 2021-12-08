package com.codeares.imagedisplay

import retrofit2.Call
import retrofit2.http.GET

public interface ImageApi {
    //val BASE_URL:String
    //= "https://reqres.in/api/users?page=2".toString()

    @GET("users?page=2")
    fun getImage(): Call<userResponse>
}