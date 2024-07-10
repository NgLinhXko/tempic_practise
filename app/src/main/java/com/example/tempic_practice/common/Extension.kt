package com.example.tempic_practice.common

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.provider.CalendarContract.Colors
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

private var application: Application? = null

fun setApplication(context: Application) {
    application = context
}

fun getApplication() = application ?: throw RuntimeException("Application context mustn't null")

fun TextView.setSpannableText(
    text: String,
    colorStart: Int = Color.BLACK,
    colorEnd: Int = Color.BLACK,
    lengthStart: Int,
    lengthAll: Int,
    fontStart: Int = Typeface.NORMAL,
    fontEnd: Int = Typeface.NORMAL
) {
    val spannable = SpannableString(text)
    spannable.setSpan(
        ForegroundColorSpan(colorStart),
        0,
        lengthStart,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    spannable.setSpan(
        ForegroundColorSpan(colorEnd),
        lengthStart,
        lengthAll,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    spannable.setSpan(
        android.text.style.StyleSpan(fontStart),
        0,
        lengthStart,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    spannable.setSpan(
        android.text.style.StyleSpan(fontEnd),
        lengthStart,
        lengthAll,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    this.text = spannable
}

fun getAppDrawable(context: Context? = getApplication(), drawableResId: Int): Drawable? {
    if (context == null) {
        return null
    }
    return ContextCompat.getDrawable(context, drawableResId)
}

fun getStringApp(context: Context? = getApplication(), stringResId: Int): String? {
    if (context == null) {
        return null
    }
    return context.getString(stringResId)
}

fun getAppColor(@ColorRes colorRes: Int, context: Context? = getApplication()) =
    context?.let { ContextCompat.getColor(it, colorRes) } ?: Color.TRANSPARENT
