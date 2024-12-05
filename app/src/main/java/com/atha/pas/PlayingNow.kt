package com.atha.pas

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PlayingNow : AppCompatActivity() {

    lateinit var mp: MediaPlayer
    lateinit var play: ImageView
    lateinit var elapsed: TextView
    lateinit var remaining: TextView
    lateinit var posisition: SeekBar
    lateinit var volume: SeekBar
    private var totalTime = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playing_now)
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
            val intent = Intent(this, profile::class.java) // Pastikan SecondActivity ada
            startActivity(intent)
        }
        val imageViewThirdButton = findViewById<ImageView>(R.id.imageView23)
        imageViewThirdButton.setOnClickListener {
            val intent = Intent(this, search::class.java) // Pastikan SecondActivity ada
            startActivity(intent)
        }
        play = findViewById(R.id.imageView15)
        elapsed = findViewById(R.id.elapsed)
        remaining = findViewById(R.id.remaining)
        posisition = findViewById(R.id.posisition)
        volume = findViewById(R.id.volume)

        mp = MediaPlayer.create(this, R.raw.billieeilish_birdsofafeather)

        play.setOnClickListener{
            if (mp.isPlaying){
                mp.pause()
                play.setImageResource(R.drawable.pausee)
            }else{
                mp.start()
                play.setImageResource(R.drawable.play)
            }
        }
        mp.isLooping = true
        mp.setVolume(0.5f,0.5f)
        totalTime = mp.duration
        posisition.max =totalTime


        Music.setSeekBar(volume,mp,true)
        Music.setSeekBar(posisition,mp,null, true)

        val handler = @SuppressLint("HandlerLeak")
        object : Handler(){
            override fun handleMessage(msg: Message) {
                val currentPosition = msg.what
                posisition.progress = currentPosition
                val elapseTime = Music.createTimeLabel(currentPosition)
                elapsed.text = elapseTime
                val remainingTime = Music.createTimeLabel(totalTime - currentPosition)
                remaining.text = "-$remainingTime"
            }
        }

        Thread(Runnable{
            while(true){
                try {
                    val msg = Message()
                    msg.what = mp.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                }catch (e: InterruptedException){
                    Log.d("Thread",e.message.toString())
                }
            }
        }).start()

    }
}