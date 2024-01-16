package com.example.hitungin

import android.os.Bundle
import android.view.View
import android.widget.*
import android.app.Activity

class MataUang : Activity() {

    private lateinit var etAmount: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var btnConvert: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.matauang)

        etAmount = findViewById(R.id.etAmount)
        spinnerFrom = findViewById(R.id.spinnerFrom)
        spinnerTo = findViewById(R.id.spinnerTo)
        btnConvert = findViewById(R.id.btnConvert)
        tvResult = findViewById(R.id.tvResult)

        val currencies = arrayOf("Rupiah (IDR)", "Dolar Amerika (USD)", "Baht (THB)", "Ringgit (MYR)", "Rial Arab Saudi (SAR)")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        btnConvert.setOnClickListener {
            convertCurrency()
        }
    }

    private fun convertCurrency() {
        val amount = etAmount.text.toString().toDouble()
        val fromCurrency = spinnerFrom.selectedItem.toString()
        val toCurrency = spinnerTo.selectedItem.toString()

        val result = when (fromCurrency) {
            "Rupiah (IDR)" -> convertToRupiah(amount, toCurrency)
            "Dolar Amerika (USD)" -> convertToUSD(amount, toCurrency)
            "Baht (THB)" -> convertToBaht(amount, toCurrency)
            "Ringgit (MYR)" -> convertToRinggit(amount, toCurrency)
            "Rial Arab Saudi (SAR)" -> convertToRial(amount, toCurrency)
            else -> amount
        }

        tvResult.text = result.toString()
    }

    private fun convertToRupiah(amount: Double, toCurrency: String): Double {
        return when (toCurrency) {
            "Rupiah (IDR)" -> amount
            "Dolar Amerika (USD)" -> amount * 0.000071
            "Baht (THB)" -> amount * 0.0022
            "Ringgit (MYR)" -> amount * 0.00028
            "Rial Arab Saudi (SAR)" -> amount * 0.00027
            else -> amount
        }
    }

    private fun convertToUSD(amount: Double, toCurrency: String): Double {
        return when (toCurrency) {
            "Rupiah (IDR)" -> amount * 15621.0
            "Dolar Amerika (USD)" -> amount
            "Baht (THB)" -> amount * 30.89
            "Ringgit (MYR)" -> amount * 4.03
            "Rial Arab Saudi (SAR)" -> amount * 3.75
            else -> amount
        }
    }

    private fun convertToBaht(amount: Double, toCurrency: String): Double {
        return when (toCurrency) {
            "Rupiah (IDR)" -> amount * 450.83
            "Dolar Amerika (USD)" -> amount * 0.032
            "Baht (THB)" -> amount
            "Ringgit (MYR)" -> amount * 0.13
            "Rial Arab Saudi (SAR)" -> amount * 0.12
            else -> amount
        }
    }

    private fun convertToRinggit(amount: Double, toCurrency: String): Double {
        return when (toCurrency) {
            "Rupiah (IDR)" -> amount * 3581.68
            "Dolar Amerika (USD)" -> amount * 0.25
            "Baht (THB)" -> amount * 7.64
            "Ringgit (MYR)" -> amount
            "Rial Arab Saudi (SAR)" -> amount * 0.93
            else -> amount
        }
    }

    private fun convertToRial(amount: Double, toCurrency: String): Double {
        return when (toCurrency) {
            "Rupiah (IDR)" -> amount * 3693.75
            "Dolar Amerika (USD)" -> amount * 0.27
            "Baht (THB)" -> amount * 8.19
            "Ringgit (MYR)" -> amount * 1.08
            "Rial Arab Saudi (SAR)" -> amount
            else -> amount
        }
    }
}
