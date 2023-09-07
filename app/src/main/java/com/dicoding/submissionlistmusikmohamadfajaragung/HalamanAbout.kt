package com.dicoding.submissionlistmusikmohamadfajaragung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class HalamanAbout : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_about)


        val back: ImageButton = findViewById(R.id.back_button)
        back.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.back_button-> {
                val intent = Intent(this@HalamanAbout, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }


}