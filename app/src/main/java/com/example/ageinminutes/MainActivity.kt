package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var selectedDateTv:TextView? = null
    private var minuteTv:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker: Button = findViewById(R.id.btnDatePick)
        selectedDateTv = findViewById(R.id.txtSelectDate)
        minuteTv = findViewById(R.id.txtMinutes)
        btnDatePicker.setOnClickListener {
            DatePick()
        }


    }
    fun DatePick() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
            val selectedDate = "$selectedDayOfMonth/$selectedMonth/$selectedYear"
            selectedDateTv?.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/mm/yyyy",Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val dateMinutes = theDate.time/60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateMinute =currentDate.time/60000
            val differenceInMinute = currentDateMinute - dateMinutes
            minuteTv?.setText(differenceInMinute.toString())
        },
            year,
            month,
            day
        ).show()
    }

}