package com.example.myapplication.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.ui.fragment.SecondFragment
import com.example.myapplication.ui.fragment.firstFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater);
        setContentView(binding.root)

//        binding first and second button from the both activity i guess
        binding.btnFirst.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.frame, firstFragment())
            fragmentTransaction.commit()
        }

        binding.btnSecond.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.frame, SecondFragment())
            fragmentTransaction.commit()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}