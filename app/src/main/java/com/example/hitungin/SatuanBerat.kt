package com.example.hitungin

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.hitungin.R
import android.widget.ArrayAdapter


class SatuanBerat : Activity() {

    private val weightUnits = arrayOf("Gram", "Kilogram", "Pon", "Ons")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.satuan_berat)

        val etInputWeight = findViewById<EditText>(R.id.etInputWeight)
        val spinnerInputUnit = findViewById<Spinner>(R.id.spinnerInputUnit)
        val spinnerOutputUnit = findViewById<Spinner>(R.id.spinnerOutputUnit)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Setup dropdown for input unit
        val inputAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, weightUnits)
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerInputUnit.adapter = inputAdapter

        // Setup dropdown for output unit
        val outputAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, weightUnits)
        outputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOutputUnit.adapter = outputAdapter

        btnConvert.setOnClickListener {
            val inputWeight = etInputWeight.text.toString().toDouble()
            val inputUnit = spinnerInputUnit.selectedItem.toString()
            val outputUnit = spinnerOutputUnit.selectedItem.toString()

            val result = convertWeight(inputWeight, inputUnit, outputUnit)

            tvResult.text = "$result"
        }
    }

    private fun convertWeight(weight: Double, inputUnit: String, outputUnit: String): Double {
        return when (inputUnit) {
            "Gram" -> when (outputUnit) {
                "Kilogram" -> weight / 1000.0
                "Pon" -> weight * 0.00220462
                "Ons" -> weight * 0.03527396
                else -> weight
            }
            "Kilogram" -> when (outputUnit) {
                "Gram" -> weight * 1000.0
                "Pon" -> weight * 2.20462
                "Ons" -> weight * 35.27396
                else -> weight
            }
            "Pon" -> when (outputUnit) {
                "Gram" -> weight * 453.592
                "Kilogram" -> weight * 0.453592
                "Ons" -> weight * 16.0
                else -> weight
            }
            "Ons" -> when (outputUnit) {
                "Gram" -> weight * 28.3495
                "Kilogram" -> weight * 0.0283495
                "Pon" -> weight * 0.0625
                else -> weight
            }
            else -> weight
        }
    }
}
