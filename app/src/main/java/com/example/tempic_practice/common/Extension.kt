package com.example.tempic_practice.common

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.provider.CalendarContract.Colors
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat


fun TextView.setSpannableText(text: String, colorStart: Int = Color.BLACK, colorEnd: Int = Color.BLACK, lengthStart: Int, lengthAll: Int, fontStart: Int = Typeface.NORMAL, fontEnd: Int = Typeface.NORMAL) {
    val spannable = SpannableString(text)
    spannable.setSpan(ForegroundColorSpan(colorStart), 0, lengthStart, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    spannable.setSpan(ForegroundColorSpan(colorEnd), lengthStart, lengthAll, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    spannable.setSpan(android.text.style.StyleSpan(fontStart), 0, lengthStart, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    spannable.setSpan(android.text.style.StyleSpan(fontEnd), lengthStart, lengthAll, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    this.text = spannable
}

fun getAppDrawable(context: Context, drawableResId: Int): Drawable? {
    return ContextCompat.getDrawable(context, drawableResId)
}

fun getStringApp(context: Context, stringResId: Int): String {
    return context.getString(stringResId)
}
