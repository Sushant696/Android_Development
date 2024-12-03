package com.example.myapplication

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class userInteraction : AppCompatActivity() {
    lateinit var toast: Button;
    lateinit var alert: Button;
    lateinit var snack: Button;
    lateinit var main: ConstraintLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)
        toast = findViewById(R.id.toast)
        snack = findViewById(R.id.snack)
        alert = findViewById(R.id.alert)
        main = findViewById(R.id.main)

        toast.setOnClickListener {
            Toast.makeText(
                this@userInteraction,
                "Invalid Login",
                Toast.LENGTH_LONG
            ).show()
        }
        alert.setOnClickListener {
            var alert = AlertDialog.Builder(this@userInteraction)
            alert
                .setTitle("Confirm")
                .setMessage("Are you sure")
                .setIcon(R.drawable.nodejs)
                .setPositiveButton("yes", DialogInterface.OnClickListener { dialogInterface, i ->
                    // when user clicks on yes - logic
                })
                .setNegativeButton(
                    "no",
                    DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })
            alert.create().show()
        }

        snack.setOnClickListener {
            Snackbar.make(main, "No Internet Connection", Snackbar.LENGTH_LONG).setAction("Retry", {
                // logic here
            }).show();
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}