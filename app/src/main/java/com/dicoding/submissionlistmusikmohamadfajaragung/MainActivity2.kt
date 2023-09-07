package com.dicoding.submissionlistmusikmohamadfajaragung

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val receivedName = intent.getStringExtra("judul")
        val receivedGenre = intent.getStringExtra("genre")
        val receivedDesc = intent.getStringExtra("lyrics")
        val receivedPhoto = intent.getIntExtra("photo",0)
        val tv_desc : TextView = findViewById(R.id.lyrics)
        val iv_photo : ImageView = findViewById(R.id.photo)
        val tv_judul : TextView = findViewById(R.id.judul)
        val tv_genre: TextView = findViewById(R.id.genre)
        tv_judul.text = receivedName
        tv_desc.text = receivedDesc
        tv_genre.text = receivedGenre
        iv_photo.setImageResource(receivedPhoto)

        val back : ImageButton = findViewById(R.id.back_button)
        back.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.back_button ->{
                val intent = Intent(this@MainActivity2, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}