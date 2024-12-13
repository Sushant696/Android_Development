package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtonBinding // reverse of your file name plus Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val du: String = "sushant"
            val dp: String = "password"

            if (binding.user.text.isEmpty()) {
                binding.user.error = "Username can't be empty"
            } else if (binding.pass.text.isEmpty()) {
                binding.pass.error = "password cannot be empty"
            } else if (binding.user.text.toString() != du) {
                binding.user.error = "Please enter a correct username"
            } else if (binding.pass.text.toString() != dp) {
                binding.pass.error = "Please enter a correct password"
            } else {
                val intent = Intent(
                    this@ButtonActivity, Destination::class.java
                ) // first is source and second one is destination to which we want to navigate
                val username: String = binding.user.text.toString();
                val password: String = binding.pass.text.toString()


                // key and value
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                startActivity(intent);
                finish() // so then when user hit back button then the prev activity will get dispose like in login screen when you login then you don't want user to go back to the login space
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}