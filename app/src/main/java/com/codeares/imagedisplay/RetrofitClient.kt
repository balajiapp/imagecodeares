package com.codeares.imagedisplay
/*
import retrofit2.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient{
    private var instance: RetrofitClient? = null
    private var myApi: Api? = null

    private fun RetrofitClient() {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(myApi?.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create<Api>()
        //Api::class.java
    }
    //@synchronised
    fun getInstance(): RetrofitClient? {
        if (instance == null) {
            //instance = RetrofitClient()
        }
        return instance
    }

    fun getMyApi(): Api? {
        return myApi
    }
}*/