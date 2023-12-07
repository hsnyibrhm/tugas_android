package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class AnimasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_animasi)
    }
}