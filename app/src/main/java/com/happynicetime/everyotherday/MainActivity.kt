package com.happynicetime.everyotherday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var textViewDay: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewDay = findViewById<TextView>(R.id.textViewDay)
        updateDay()
    }
    override fun onResume() {
        super.onResume()
        updateDay()
    }
    private fun updateDay(){
        val c = Calendar.getInstance()
        var timeInt = (c.getTimeInMillis() / (1000 * 60 * 60 * 24)).toInt()
        var isOddDay = timeInt % 2
        if(isOddDay == 1){
            textViewDay.setText("\"A\"\nday")
        }else{
            textViewDay.setText("\"B\"\nday")
        }
    }
}