package com.codeares.imagedisplay

import com.google.gson.annotations.SerializedName
import java.util.*


class userResponse {
    @SerializedName("data")
    var data = ArrayList<user>()

    @SerializedName("page")
    var page: Int = 0
    @SerializedName("per_page")
    var per_page: Int = 0
    @SerializedName("total")
    var total: Int = 0
    @SerializedName("total_pages")
    var total_pages: Int = 0

}

class user {
    @SerializedName("id")
    var id:String =""
    @SerializedName("email")
    var email:String= ""
    @SerializedName("first_name")
    var firstname:String= ""
    @SerializedName("last_name")
    var lastname: String= ""
    @SerializedName("avatar")
    var avatar:String= ""
}