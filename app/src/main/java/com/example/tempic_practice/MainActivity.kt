package com.example.tempic_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var timeSeekBar: TimeSeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeSeekBar = findViewById(R.id.timeSeekBar)
        timeSeekBar.setTimeRange("01:00:00", "03:00:00")
        var dialog = CustomDatePickerDialog(
            this,
            Calendar.getInstance(),
            onUpdateSelectedDate = {

            })
        dialog.show()

    }
}