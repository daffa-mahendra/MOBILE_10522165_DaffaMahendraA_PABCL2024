package com.example.hitungin

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner



class SatuanVolume : Activity() {

    private lateinit var etInputVolume: EditText
    private lateinit var spinnerInputUnit: Spinner
    private lateinit var spinnerOutputUnit: Spinner
    private lateinit var btnConvert: Button
    private lateinit var tvResult: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.satuan_volume)

        etInputVolume = findViewById(R.id.etInputVolume)
        spinnerInputUnit = findViewById(R.id.spinnerInputUnit)
        spinnerOutputUnit = findViewById(R.id.spinnerOutputUnit)
        btnConvert = findViewById(R.id.btnConvert)
        tvResult = findViewById(R.id.tvResult)

        val volumeUnits = arrayOf("Milliliter", "Liter", "Cubic Meter", "Gallon")

        val inputAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, volumeUnits)
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerInputUnit.adapter = inputAdapter

        val outputAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, volumeUnits)
        outputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOutputUnit.adapter = outputAdapter

        btnConvert.setOnClickListener {
            convertVolume()
        }
    }

    private fun convertVolume() {
        val inputVolume = etInputVolume.text.toString().toDouble()
        val inputUnit = spinnerInputUnit.selectedItem.toString()
        val outputUnit = spinnerOutputUnit.selectedItem.toString()

        val result = when (inputUnit) {
            "Milliliter" -> convertToMilliliter(inputVolume, outputUnit)
            "Liter" -> convertToLiter(inputVolume, outputUnit)
            "Cubic Meter" -> convertToCubicMeter(inputVolume, outputUnit)
            "Gallon" -> convertToGallon(inputVolume, outputUnit)
            else -> inputVolume
        }

        tvResult.setText(result.toString())
    }

    private fun convertToMilliliter(volume: Double, outputUnit: String): Double {
        return when (outputUnit) {
            "Milliliter" -> volume
            "Liter" -> volume * 0.001
            "Cubic Meter" -> volume * 1e-6
            "Gallon" -> volume * 0.000264172
            else -> volume
        }
    }

    private fun convertToLiter(volume: Double, outputUnit: String): Double {
        return when (outputUnit) {
            "Milliliter" -> volume * 1000.0
            "Liter" -> volume
            "Cubic Meter" -> volume * 0.001
            "Gallon" -> volume * 0.264172
            else -> volume
        }
    }

    private fun convertToCubicMeter(volume: Double, outputUnit: String): Double {
        return when (outputUnit) {
            "Milliliter" -> volume * 1e6
            "Liter" -> volume * 1000.0
            "Cubic Meter" -> volume
            "Gallon" -> volume * 264.172
            else -> volume
        }
    }

    private fun convertToGallon(volume: Double, outputUnit: String): Double {
        return when (outputUnit) {
            "Milliliter" -> volume * 3785.41
            "Liter" -> volume * 3.78541
            "Cubic Meter" -> volume * 0.00378541
            "Gallon" -> volume
            else -> volume
        }
    }
}
