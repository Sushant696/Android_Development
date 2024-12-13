package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class Dropdown : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var dropdown: Spinner;
    lateinit var displayText: TextView;
    lateinit var autoCompleteTextView: AutoCompleteTextView;
    lateinit var datePicker: EditText;

    private var countries = arrayOf("Nepal", "India", "USA", "Japan", "Australia");
    val cities = arrayOf("Kathmandu", "lalitpur", "jhapa", "chandragadi", "kanchanpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dropdown)


        dropdown = findViewById(R.id.spinner);
        displayText = findViewById(R.id.selected);
        autoCompleteTextView = findViewById(R.id.autocom);
        datePicker = findViewById(R.id.date);

        datePicker.isFocusable = false;
        datePicker.isClickable = true;
        datePicker.setOnClickListener {
            loadCalender();
        }


        // autocomplete adapter setup
        val autoCompleteAdapter = ArrayAdapter(
            this@Dropdown, android.R.layout.simple_dropdown_item_1line, cities
        )
        autoCompleteTextView.setAdapter(autoCompleteAdapter)
        autoCompleteTextView.threshold = 1;


        //  spinner setup adapter
        val adapter = ArrayAdapter(
            this@Dropdown, android.R.layout.simple_spinner_dropdown_item, countries
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        dropdown.onItemSelectedListener = this;
        dropdown.adapter = adapter;


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    // custom private functions
    private fun loadCalender() {
        val c = Calendar.getInstance();
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH);

        val dialog = DatePickerDialog(
            this@Dropdown, DatePickerDialog.OnDateSetListener { d, year, month, day ->
                // 2024 12 05
                datePicker.setText("$day/${month + 1}/$year")
            }, year, month, day
        )
        dialog.show()
    }

    // override functions
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        displayText.text = p0?.getItemAtPosition(p2).toString();
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        displayText.text = "No selection made."
    }
}