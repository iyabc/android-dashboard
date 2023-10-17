package com.example.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val backBtn = findViewById<Button>(R.id.back_btn)

        backBtn.setOnClickListener {
            val dashboardScreen = Intent (this, MainActivity::class.java)
            startActivity(dashboardScreen)
        }
    }
}