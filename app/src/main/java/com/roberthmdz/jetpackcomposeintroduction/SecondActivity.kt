package com.roberthmdz.jetpackcomposeintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Add a compose instead of a layout xml
        setContent {
            Text(text = "Hello")
        }
    }
}