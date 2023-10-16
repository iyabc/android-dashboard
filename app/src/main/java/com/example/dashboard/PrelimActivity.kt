
package com.example.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class PrelimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prelim)

        val loginBtn = findViewById<Button>(R.id.login_button)

        loginBtn.setOnClickListener {
            val dashboardScreen = Intent(this, MainActivity::class.java)
            startActivity(dashboardScreen)
        }

    }
}