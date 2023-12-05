package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val Diskirpsi: String,
    val Spesifik: String,
    val photo: Int
):Parcelable
