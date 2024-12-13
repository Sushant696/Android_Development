package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Mylist : AppCompatActivity() {

    lateinit var listView: ListView
    val contacts = arrayOf(
        "Nishan",
        "ram",
        "shyam",
        "samir",
        "rojit",
        "nirjal",
        "sushant",
        "Nishan",
        "ram",
        "shyam",
        "samir",
        "rojit",
        "nirjal",
        "sushant",
        "Nishan",
        "Nishan",
        "ram",
        "shyam",
        "samir",
        "rojit",
        "nirjal",
        "sushant",
        "Nishan",
        "ram",
        "shyam",
        "samir",
        "rojit",
        "nirjal",
        "sushant",
        "Nishan"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mylist)

        listView = findViewById(R.id.listview)

        val adapter = ArrayAdapter(
            this@Mylist, android.R.layout.simple_list_item_1, contacts
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            if (adapterView != null) {
                Toast.makeText(
                    this@Mylist,
                    adapterView.getItemAtPosition(i).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
