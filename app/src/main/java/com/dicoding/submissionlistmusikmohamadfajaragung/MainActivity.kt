package com.dicoding.submissionlistmusikmohamadfajaragung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvSongs: RecyclerView
    private val list = ArrayList<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvSongs = findViewById(R.id.rv_songs)
        rvSongs.setHasFixedSize(true)

        list.addAll(getListSongs())
        showRecyclerList()

        val imgBtnProfile: ImageButton = findViewById(R.id.img_button_profile)
        imgBtnProfile.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_button_profile -> {
                val intent = Intent(this@MainActivity, HalamanAbout::class.java)
                startActivity(intent)
            }
        }
    }
    private fun getListSongs(): ArrayList<Song> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataOverview = resources.getStringArray(R.array.data_genre)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDesc = resources.getStringArray(R.array.data_lirics)
        val listSong = ArrayList<Song>()
        for (i in dataName.indices) {
            val song =
                Song(dataName[i], dataOverview[i], dataPhoto.getResourceId(i, -1), dataDesc[i])
            listSong.add(song)
        }
        return listSong
    }

    private fun showRecyclerList() {
        rvSongs.layoutManager = LinearLayoutManager(this)
        val listSongAdapter = ListSongAdapter(this, list)
        rvSongs.adapter = listSongAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_list->{
                rvSongs.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid->{
                rvSongs.layoutManager = GridLayoutManager(this,2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}