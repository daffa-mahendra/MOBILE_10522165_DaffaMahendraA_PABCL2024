package com.example.hitungin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.app.Activity

class Kalkulator : Activity() {

    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalkulator)

        resultTextView = findViewById(R.id.resultTextView)

        val numberButtons = listOf<Button>(
            findViewById(R.id.btn0),
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        )

        val operatorButtons = listOf<Button>(
            findViewById(R.id.btnAdd),
            findViewById(R.id.btnSubtract),
            findViewById(R.id.btnMultiply),
            findViewById(R.id.btnDivide),
            findViewById(R.id.btnPercent)
        )

        val equalsButton = findViewById<Button>(R.id.btnEquals)
        val clearButton = findViewById<Button>(R.id.btnClear)

        for (button in numberButtons) {
            button.setOnClickListener { appendNumber(button.text.toString()) }
        }

        for (button in operatorButtons) {
            button.setOnClickListener { setOperator(button.text.toString()) }
        }

        equalsButton.setOnClickListener { calculateResult() }
        clearButton.setOnClickListener { clearAll() }
    }

    private fun appendNumber(number: String) {
        resultTextView.append(number)
    }

    private fun setOperator(op: String) {
        if (resultTextView.text.isNotEmpty()) {
            operand1 = resultTextView.text.toString().toDouble()
            operator = op
            resultTextView.text = ""
        }
    }

    private fun calculateResult() {
        if (resultTextView.text.isNotEmpty()) {
            val operand2 = resultTextView.text.toString().toDouble()
            val result = when (operator) {
                "+" -> operand1 + operand2
                "-" -> operand1 - operand2
                "x" -> operand1 * operand2
                "/" -> if (operand2 != 0.0) operand1 / operand2 else Double.NaN
                "%" -> operand1 % operand2
                else -> Double.NaN
            }
            resultTextView.text = result.toString()
            operator = ""
        }
    }

    private fun clearAll() {
        resultTextView.text = ""
        operand1 = 0.0
        operator = ""
    }
}
