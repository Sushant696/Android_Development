package com.example.myapplication

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var nodejs: RadioButton
    lateinit var springBoot: RadioButton
    lateinit var djando: RadioButton
    lateinit var image: ImageView
    lateinit var text :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio2)
        nodejs = findViewById(R.id.radioNodejs)
        springBoot = findViewById(R.id.springboot)
        djando = findViewById(R.id.django)
        image = findViewById(R.id.image)
        text = findViewById(R.id.currentTool)
        text.text = "Initially selected -> Spring boot"

        nodejs.setOnClickListener {
            image.setImageResource(R.drawable.nodejs)
            text.text = "Currently Selected -> Node js"
        }
        springBoot.setOnClickListener {
            image.setImageResource(R.drawable.swappy_20241118_101924)
            text.text = "Currently Selected -> Spring boot"
        }
        djando.setOnClickListener {
            image.setImageResource(R.drawable.swappy_20241118_104116)
            text.text = "Currently Selected -> django"
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}