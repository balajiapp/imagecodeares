package com.codeares.imagedisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pon.vvgapp.ui.coursesearch.ImageAdapter
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

lateinit var retrofit: Retrofit;
lateinit var recyclerView: RecyclerView
//lateinit var recyclerAdapter
var userList: ArrayList<user> = ArrayList()
var ImageDataRetry: Int = 0;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = this.findViewById<RecyclerView>(R.id.recyclerview1)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ImageAdapter(this,userList )

        retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        ImageDataRetry = 0
        getImageData()
    }

    fun getImageData() {

        var service = retrofit.create(ImageApi::class.java)
        //retrofit.create(ImageApi::class<T>)
        var call = service.getImage()

        call.enqueue(object : Callback<userResponse> {
            override fun onResponse(call: Call<userResponse>, response: Response<userResponse>) {
                if (response.code() == 200) {
                    var userResponse:userResponse = response.body()!!
                    Log.d("RESPONSE", Gson().toJson(userResponse.data).toString() )

                    userList.addAll(userResponse.data)


                    for (user in userResponse.data){
                        //userList.add(user.)
                    }
                    //Log.d("userList", userList.toString() )

                    recyclerView.adapter?.notifyDataSetChanged()

                    //GsonBuilder().setPrettyPrinting().create().toJson(response)
                }
            }

            override fun onFailure(call: Call<userResponse>, t: Throwable) {
                //weatherData!!.text = t.message
                Log.d("Error", "API call failed" + ImageDataRetry .toString())
                if(ImageDataRetry < 1){
                    getImageData()
                    ImageDataRetry++
                    }

            }
        })
    }

    companion object {
        var BaseUrl = "https://reqres.in/api/"
    }
}