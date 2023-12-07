package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myrecyclerview.databinding.ActivityBotomNavBinding

class BotomNavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBotomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBotomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        replaceFragment(AlarmFragment())

        binding.bottomNavigationView.setOnItemSelectedListener{ menuItem ->
            when(menuItem.itemId){
                R.id.alarm ->replaceFragment(AlarmFragment())

                else->{

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}