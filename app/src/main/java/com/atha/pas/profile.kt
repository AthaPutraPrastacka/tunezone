package com.atha.pas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
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
        val imageViewSecondButton = findViewById<ImageView>(R.id.imageView23)
        imageViewSecondButton.setOnClickListener {
            val intent = Intent(this, search::class.java) // Pastikan SecondActivity ada
            startActivity(intent)
        }
        val imageViewFourthButton = findViewById<ImageView>(R.id.imageView16)
        imageViewFourthButton.setOnClickListener {
            val intent = Intent(this, PlayingNow::class.java)
            startActivity(intent)
        }
        val imageViewFifthButton = findViewById<ImageView>(R.id.imageView18)
        imageViewFifthButton.setOnClickListener {
            val intent = Intent(this, Playlist::class.java)
            startActivity(intent)
        }
        val imageViewSixthButton = findViewById<ImageView>(R.id.imageView26)
        imageViewSixthButton.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }
    }
}