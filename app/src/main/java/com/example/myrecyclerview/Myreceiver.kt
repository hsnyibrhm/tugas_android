package com.example.myrecyclerview

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class Myreceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Alarm Nyalaaaaa!!!!", Toast.LENGTH_SHORT).show()
        Log.d("INI", "NYALAA : "+ System.currentTimeMillis())
    }
}