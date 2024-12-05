package com.atha.pas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageViewButton = findViewById<ImageView>(R.id.imageView2)
        imageViewButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val imageViewSecondButton = findViewById<ImageView>(R.id.imageView22)
        imageViewSecondButton.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }
        val imageViewThirdButton = findViewById<ImageView>(R.id.imageView16)
        imageViewThirdButton.setOnClickListener {
            val intent = Intent(this, PlayingNow::class.java)
            startActivity(intent)
        }
    }
}