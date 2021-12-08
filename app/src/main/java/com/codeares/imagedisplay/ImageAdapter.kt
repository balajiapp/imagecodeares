package com.pon.vvgapp.ui.coursesearch

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codeares.imagedisplay.R
import com.codeares.imagedisplay.user
import java.text.SimpleDateFormat
import java.util.Collections.emptyList


class ImageAdapter(
    context: Context,
    data: List<user>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater
    var data: List<user> = emptyList<user>()
    var current: user? = null
    var currentPos = 0
    var context = context;


    // Inflate the layout when viewholder created
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view: View = inflater.inflate(R.layout.userimage, parent, false)
        return MyHolder(view)
    }

    // Bind data

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {

        // Get current position of item in recyclerview to bind data and assign values from list
        val myHolder = holder as MyHolder
        val current: user = data[position]

        myHolder.user_name.setText((current.firstname + " " + current.lastname).toString())
        //myHolder.userImage.

        Log.d(position.toString(),(current.firstname + " " + current.lastname).toString())

        Glide.with(context)
            .load(current.avatar)
            .into(myHolder.userImage)
    }

    // return total item from List
    override fun getItemCount(): Int {
        return data.size
    }

    internal inner class MyHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var user_name: TextView
        var userImage: ImageView

        // create constructor to get widget reference
        init {
            user_name = itemView.findViewById<View>(R.id.textView) as TextView
            userImage = itemView.findViewById<View>(R.id.imageView) as ImageView
        }
    }

    // create constructor to innitilize context and data sent from MainActivity
    init {
        inflater = LayoutInflater.from(context)
        this.data = data
    }
}