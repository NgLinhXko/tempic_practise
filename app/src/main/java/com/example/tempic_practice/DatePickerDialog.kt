package com.example.tempic_practice

import android.app.DatePickerDialog
import android.content.Context
import java.util.Calendar
import java.util.Date

class CustomDatePickerDialog(
    context: Context,
    calendar: Calendar,
    onUpdateSelectedDate: ((Date) -> Unit)? = null
) : DatePickerDialog(
    context,
    OnDateSetListener { _, year: Int, monthOfYear: Int, dayOfMonth: Int ->
        val selectedDate = Calendar.getInstance()
        selectedDate.set(year, monthOfYear, dayOfMonth)
        onUpdateSelectedDate?.invoke(selectedDate.time)
    },
    calendar.get(Calendar.YEAR),
    calendar.get(Calendar.MONTH),
    calendar.get(Calendar.DAY_OF_MONTH)
) {


}
