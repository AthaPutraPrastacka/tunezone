package com.atha.pas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Mengatur padding untuk menghindari system bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menambahkan listener ke ImageView
        val imageViewButton = findViewById<ImageView>(R.id.imageView10)
        imageViewButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val textViewButton = findViewById<TextView>(R.id.textView17)
        textViewButton.setOnClickListener{
            val intent = Intent(this, registerr::class.java)
            startActivity(intent)
        }

    }
}
