package com.example.tempic_practice

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Locale

class TimeSeekBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var seekBar: SeekBar
    private var tvCurrentTime: TextView

    private var startTimeMillis: Long = 0
    private var endTimeMillis: Long = 0

    init {
        // Inflate the layout for this view
        inflate(context, R.layout.seek_bar_layout, this)

        // Get references to the SeekBar and TextView
        seekBar = findViewById(R.id.seekBar)
        tvCurrentTime = findViewById(R.id.tvCurrentTime)

        // Setup default time values (adjust as needed)
        setTimeRange("00:00:00", "02:00:00") // Default start and end time
    }

    // Set the start and end time in hh:mm:ss format
    fun setTimeRange(startTime: String, endTime: String) {
        startTimeMillis = timeToMillis(startTime)
        endTimeMillis = timeToMillis(endTime)

        // Set SeekBar max based on time range
        seekBar.max = (endTimeMillis - startTimeMillis).toInt()

        // Add a listener to handle progress change
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Calculate the current time based on progress
                val currentTimeMillis = startTimeMillis + progress
                val currentTime = millisToTime(currentTimeMillis)

                // Display the current time in the TextView
                tvCurrentTime.text = currentTime
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Optional: Handle when the user starts dragging the SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Optional: Handle when the user stops dragging the SeekBar
            }
        })
    }

    // Convert time string (hh:mm:ss) to milliseconds
    private fun timeToMillis(time: String): Long {
        val parts = time.split(":")
        val hours = parts[0].toLong() * 3600000 // 1 hour = 3600000 ms
        val minutes = parts[1].toLong() * 60000 // 1 minute = 60000 ms
        val seconds = parts[2].toLong() * 1000 // 1 second = 1000 ms
        return hours + minutes + seconds
    }

    // Convert milliseconds to time string (hh:mm:ss)
    private fun millisToTime(millis: Long): String {
        val hours = millis / (1000 * 60 * 60) % 24
        val minutes = millis / (1000 * 60) % 60
        val seconds = millis / 1000 % 60
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}
