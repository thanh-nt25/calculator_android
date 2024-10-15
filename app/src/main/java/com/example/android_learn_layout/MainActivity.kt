package com.example.android_learn_layout

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
//import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {

    private lateinit var display: TextView
    private var currentNumber = ""
    private var operator = ""
    private var firstNumber = 0.0
    private var secondNumber = 0.0
    private var result = 0.0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_linear)

        display = findViewById(R.id.tv_display)

        findViewById<Button>(R.id.bnt_0).setOnClickListener { appendNumber("0") }
        findViewById<Button>(R.id.bnt_1).setOnClickListener { appendNumber("1") }
        findViewById<Button>(R.id.bnt_2).setOnClickListener { appendNumber("2") }
        findViewById<Button>(R.id.bnt_3).setOnClickListener { appendNumber("3") }
        findViewById<Button>(R.id.bnt_4).setOnClickListener { appendNumber("4") }
        findViewById<Button>(R.id.bnt_5).setOnClickListener { appendNumber("5") }
        findViewById<Button>(R.id.bnt_6).setOnClickListener { appendNumber("6") }
        findViewById<Button>(R.id.bnt_7).setOnClickListener { appendNumber("7") }
        findViewById<Button>(R.id.bnt_8).setOnClickListener { appendNumber("8") }
        findViewById<Button>(R.id.bnt_9).setOnClickListener { appendNumber("9") }

        findViewById<Button>(R.id.bnt_dot).setOnClickListener { appendNumber(".") }

        findViewById<Button>(R.id.bnt_add).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.bnt_subtract).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.bnt_multiply).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.bnt_divide).setOnClickListener { setOperator("/") }

        findViewById<Button>(R.id.bnt_equal).setOnClickListener { calculateResult() }

        findViewById<Button>(R.id.bnt_ce).setOnClickListener { clearEntry() }

        findViewById<Button>(R.id.bnt_c).setOnClickListener { clearAll() }

        findViewById<Button>(R.id.bnt_bs).setOnClickListener { backspace() }
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        display.text = currentNumber
    }

    private fun setOperator(op: String) {
        if (currentNumber.isNotEmpty()) {
            firstNumber = currentNumber.toDouble()
            operator = op
            currentNumber = ""
        }
    }

    private fun calculateResult() {
        if (currentNumber.isNotEmpty()) {
            secondNumber = currentNumber.toDouble()
            result = when (operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> 0.0
            }
            display.text = result.toString()
            currentNumber = result.toString()
        }
    }

    private fun clearEntry() {
        currentNumber = ""
        display.text = "0"
    }

    private fun clearAll() {
        currentNumber = ""
        firstNumber = 0.0
        secondNumber = 0.0
        operator = ""
        display.text = "0"
    }

    private fun backspace() {
        if (currentNumber.isNotEmpty()) {
            currentNumber = currentNumber.dropLast(1)
            display.text = if (currentNumber.isNotEmpty()) currentNumber else "0"
        }
    }
}
