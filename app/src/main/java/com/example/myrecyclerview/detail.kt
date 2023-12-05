package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class detail : AppCompatActivity() {
    companion object {
        const val EXTRA_Player = "extra_player"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val player = intent.getParcelableExtra<Player>(EXTRA_Player)


        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvOverview: TextView = findViewById(R.id.tv_set_overview)
        val ppp: TextView = findViewById(R.id.tv_item_name)
        val spek: TextView = findViewById(R.id.tv_det)


        if (player != null) {
            Glide.with(this)
                .load(player.photo)
                .centerCrop()
                .into(imgPhoto)

            tvOverview.text = player.Diskirpsi
            ppp.text = player.name
            spek.text = player.Spesifik
        }
    }
}