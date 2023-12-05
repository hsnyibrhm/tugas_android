package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var button1: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main2)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        button1 = findViewById(R.id.button2)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView2)

        textView.text = viewModel.angka.toString()

        button.setOnClickListener {
            viewModel.tambahAngkaDengan1()
            textView.text = viewModel.angka.toString()
        }

        button1.setOnClickListener {
            viewModel.tambahAngkaDengan2()
            textView.text = viewModel.angka.toString()
        }
    }
}
