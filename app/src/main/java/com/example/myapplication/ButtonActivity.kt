package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtonBinding // reverse of your file name plus Binding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)


        binding.btn.setOnClickListener {
            val du: String = "sushant"
            val dp: String = "password"
            val username: String = binding.user.text.toString();
            val password: String = binding.pass.text.toString()
            val savedUsername: String = sharedPreferences.getString("username","").toString();
            val savedPassword: String = sharedPreferences.getString("password"," ").toString();

            if (username.isEmpty()) {
                binding.user.error = "Username can't be empty"
            } else if (binding.pass.text.isEmpty()) {
                binding.pass.error = "password cannot be empty"
            } else if (binding.user.text.toString() != du) {
                binding.user.error = "Please enter a correct username"
            } else if (binding.pass.text.toString() != dp) {
                binding.pass.error = "Please enter a correct password"
            } else if (savedUsername == du || savedPassword == dp) {
                val intent = Intent (this@ButtonActivity, Destination::class.java)
                startActivity(intent)
            } else {
                if (binding.check.isChecked) {
                    val editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("password", password)
                    editor.apply();
                }
                val intent = Intent(
                    this@ButtonActivity, Destination::class.java
                ) // first is source and second one is destination to which we want to navigate

                // key and value
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                startActivity(intent);
//                finish() // so then when user hit back button then the prev activity will get dispose like in login screen when you login then you don't want user to go back to the login space
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}