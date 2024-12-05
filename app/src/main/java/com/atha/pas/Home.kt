package com.atha.pas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Mengatur padding untuk menghindari system bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menambahkan listener ke ImageView
        val imageViewButton = findViewById<ImageView>(R.id.imageView23)
        imageViewButton.setOnClickListener {
            val intent = Intent(this, search::class.java)
            startActivity(intent)
        }
        val imageViewSecondButton = findViewById<ImageView>(R.id.imageView22)
        imageViewSecondButton.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }
        val imageViewThirdButton = findViewById<ImageView>(R.id.imageView4)
        imageViewThirdButton.setOnClickListener {
            val intent = Intent(this, search::class.java)
            startActivity(intent)
        }
        val imageViewFourthButton = findViewById<ImageView>(R.id.imageView3)
        imageViewFourthButton.setOnClickListener {
            val intent = Intent(this, PlayingNow::class.java)
            startActivity(intent)
        }
        val imageViewFifthButton = findViewById<ImageView>(R.id.imageView7)
        imageViewFifthButton.setOnClickListener {
            val intent = Intent(this, PlayingNow::class.java)
            startActivity(intent)
        }
    }
}
