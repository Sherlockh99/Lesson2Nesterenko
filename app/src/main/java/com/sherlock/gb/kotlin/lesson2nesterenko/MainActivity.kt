package com.sherlock.gb.kotlin.lesson2nesterenko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sherlock.gb.kotlin.lesson2nesterenko.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}