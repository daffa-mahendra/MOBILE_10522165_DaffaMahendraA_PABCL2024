package com.example.hitungin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class Menu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.menu)
            val kalkulator = findViewById<Button>(R.id.button1)
            kalkulator.setOnClickListener {
                val Intent = Intent(this, Kalkulator::class.java)
                startActivity(Intent)
            }
            val mataUang = findViewById<Button>(R.id.button2)
            mataUang.setOnClickListener {
                val Intent = Intent(this, MataUang::class.java)
                startActivity(Intent)
            }
            val berat = findViewById<Button>(R.id.button3)
            berat.setOnClickListener {
                val Intent = Intent(this, SatuanBerat::class.java)
                startActivity(Intent)
            }
            val panjang = findViewById<Button>(R.id.button4)
            panjang.setOnClickListener {
                val Intent = Intent(this, SatuanPanjang::class.java)
                startActivity(Intent)
            }
            val volume = findViewById<Button>(R.id.button5)
            volume.setOnClickListener {
                val Intent = Intent(this, SatuanVolume::class.java)
                startActivity(Intent)
            }
        }
    }
}


