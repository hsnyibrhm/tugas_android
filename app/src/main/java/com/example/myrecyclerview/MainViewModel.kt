package com.example.myrecyclerview

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var angka = 0

    fun tambahAngkaDengan1(){
        angka++
    }

    fun tambahAngkaDengan2(){
        angka += 2
    }
}