package com.example.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class QPIActivity : AppCompatActivity() {
    var totalEquationString: String = ""
    lateinit var letterBtnsArray: IntArray
    lateinit var numberBtnsArray: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_qpi_calculator)

        val btnA: Button = findViewById(R.id.btnA)
        val btnBP: Button = findViewById(R.id.btnBP)
        val btnB: Button = findViewById(R.id.btnB)
        val btnCP: Button = findViewById(R.id.btnCP)
        val btnC: Button = findViewById(R.id.btnC)
        val btnD: Button = findViewById(R.id.btnD)
        val btnF: Button = findViewById(R.id.btnF)

        val btnU3: Button = findViewById(R.id.btnU3)
        val btnU5: Button = findViewById(R.id.btnU5)
        val btnU9: Button = findViewById(R.id.btnU9)

        val backBtn = findViewById<Button>(R.id.back_btn)

        letterBtnsArray = intArrayOf(btnA.id, btnBP.id,btnB.id,btnCP.id,btnC.id,btnD.id,btnF.id)
        numberBtnsArray = intArrayOf(btnU3.id, btnU5.id, btnU9.id)

        backBtn.setOnClickListener {
            val dashboardScreen = Intent (this, MainActivity::class.java)
            startActivity(dashboardScreen)
        }

    }

    fun handleLetterButtonClick(view:View) {
        val btn: Button = findViewById(view.id)
        handleDisableButtons()

        if(totalEquationString.length < 1){
            totalEquationString += "(${btn.text} "
        }else {
            totalEquationString += " + (${btn.text} "
        }

        handleDisplayEquation(totalEquationString)

    }

    fun handleNumberButtonClick(view:View) {
        val btn: Button = findViewById(view.id)
        handleDisableButtons()
        totalEquationString += "* ${btn.text.toString().toDouble()})"
        handleDisplayEquation(totalEquationString)
    }

    fun handleDisplayEquation(value: String) {
        val etEquation: EditText = findViewById(R.id.etEquation)


        etEquation.setText(totalEquationString)
    }

    fun handleClearButtonClick(view: View) {
        val etEquation: EditText = findViewById(R.id.etEquation)
        totalEquationString = ""
        etEquation.setText("")
        handleDisableButtons()
    }

    fun handleDisableButtons() {
        Log.d("ZZZZZZZZZ", "Disable buttons")

        for(letterId in letterBtnsArray) {
            var currentBtn = findViewById<Button>(letterId)
            currentBtn.isEnabled = !currentBtn.isEnabled
            Log.d("ZZZZZZZ", currentBtn.isEnabled.toString())
        }

        for(numberId in numberBtnsArray) {
            var currentBtn = findViewById<Button>(numberId)
            currentBtn.isEnabled = !currentBtn.isEnabled
        }
    }

}