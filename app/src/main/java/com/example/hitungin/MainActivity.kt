package com.example.hitungin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hitungin.ui.theme.HitunginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_main)

            val menuButton = findViewById<Button>(R.id.menu_btn)
            menuButton.setOnClickListener{
                val Intent = Intent(this,Menu::class.java)
                startActivity(Intent)
            }
        }


            }
        }
