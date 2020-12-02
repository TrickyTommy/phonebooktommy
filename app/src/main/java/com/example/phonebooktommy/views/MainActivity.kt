package com.example.phonebooktommy.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phonebooktommy.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }
}