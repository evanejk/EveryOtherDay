package com.happynicetime.everyotherday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Calendar
import java.util.TimeZone

class MainActivity : AppCompatActivity() {
    private lateinit var textViewDays2: TextView
    private lateinit var textViewDays3: TextView
    //private lateinit var textViewDays4: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewDays2 = findViewById<TextView>(R.id.textViewDays2)
        textViewDays3 = findViewById<TextView>(R.id.textViewDays3)
        //textViewDays4 = findViewById<TextView>(R.id.textViewDays4)
        updateDay()
    }
    override fun onResume() {
        super.onResume()
        updateDay()
    }
    private fun updateDay() {
        val c = Calendar.getInstance()
        var timeInt =
            ((TimeZone.getDefault().rawOffset + c.getTimeInMillis()) / (1000 * 60 * 60 * 24)).toInt()
        var isOddDay = timeInt % 2
        if (isOddDay == 1) {
            textViewDays2.setText("\"2A\"")
        } else {
            textViewDays2.setText("\"2B\"")
        }
        when(timeInt % 3){
            1 -> textViewDays3.setText("\"3A\"")
            2 -> textViewDays3.setText("\"3B\"")
            0 -> textViewDays3.setText("\"3C\"")
        }
        /*when(timeInt % 4){
            1 -> textViewDays4.setText("\"4A\"")
            2 -> textViewDays4.setText("\"4B\"")
            3 -> textViewDays4.setText("\"4C\"")
            0 -> textViewDays4.setText("\"4D\"")
        }*/
    }
}