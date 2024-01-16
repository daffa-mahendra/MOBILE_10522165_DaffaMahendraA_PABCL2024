package com.example.hitungin

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.StringRes
import android.app.Activity

class SatuanPanjang : Activity() {

    private val lengthUnits = arrayOf("Meter", "Kilometer", "Centimeter", "Millimeter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.satuan_panjang)

        val etInputLength = findViewById<EditText>(R.id.etInputLength)
        val spinnerInputUnit = findViewById<Spinner>(R.id.spinnerInputUnit)
        val spinnerOutputUnit = findViewById<Spinner>(R.id.spinnerOutputUnit)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Setup dropdown for input unit
        val inputAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lengthUnits)
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerInputUnit.adapter = inputAdapter

        // Setup dropdown for output unit
        val outputAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lengthUnits)
        outputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOutputUnit.adapter = outputAdapter

        btnConvert.setOnClickListener {
            val inputLength = etInputLength.text.toString().toDouble()
            val inputUnit = spinnerInputUnit.selectedItem.toString()
            val outputUnit = spinnerOutputUnit.selectedItem.toString()

            val result = convertLength(inputLength, inputUnit, outputUnit)

            tvResult.text = "$result"
        }
    }

    private fun convertLength(length: Double, inputUnit: String, outputUnit: String): Double {
        return when (inputUnit) {
            "Meter" -> when (outputUnit) {
                "Kilometer" -> length / 1000.0
                "Centimeter" -> length * 100.0
                "Millimeter" -> length * 1000.0
                else -> length
            }
            "Kilometer" -> when (outputUnit) {
                "Meter" -> length * 1000.0
                "Centimeter" -> length * 100000.0
                "Millimeter" -> length * 1000000.0
                else -> length
            }
            "Centimeter" -> when (outputUnit) {
                "Meter" -> length / 100.0
                "Kilometer" -> length / 100000.0
                "Millimeter" -> length * 10.0
                else -> length
            }
            "Millimeter" -> when (outputUnit) {
                "Meter" -> length / 1000.0
                "Kilometer" -> length / 1000000.0
                "Centimeter" -> length / 10.0
                else -> length
            }
            else -> length
        }
    }
}
