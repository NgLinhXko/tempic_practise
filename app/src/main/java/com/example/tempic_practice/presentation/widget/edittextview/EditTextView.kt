package com.example.tempic_practice.presentation.widget.edittextview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.addTextChangedListener
import com.example.tempic_practice.R

class EditTextView constructor(ctx: Context, attrs: AttributeSet?) : FrameLayout(ctx, attrs) {
    private var llEditText: LinearLayout? = null
    private var frlEditText: FrameLayout? = null
    private var edtEditTextUserName: AppCompatEditText? = null
    private var tvEditTextTime: AppCompatTextView? = null
    private var tvEditTextOtp: AppCompatTextView? = null

    //callback
    private var onTextChange: ((String) -> Unit)? = null
    private var onOtpClick: (() -> Unit)? = null

    init {
        LayoutInflater.from(ctx).inflate(R.layout.edit_text_view, this, true)
        initView(ctx, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {
        llEditText = findViewById(R.id.llEditText)
        edtEditTextUserName = findViewById(R.id.edtEditTextUserName)
        tvEditTextTime = findViewById(R.id.tvEditTextTime)
        tvEditTextOtp = findViewById(R.id.tvEditTextOtp)
        frlEditText = findViewById(R.id.frlEditText)

        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.EditTextView, 0, 0)
        //text field
        val content = typedArray.getString(R.styleable.EditTextView_text_content)
        val hint = typedArray.getString(R.styleable.EditTextView_hint_text)
        val textRight = typedArray.getString(R.styleable.EditTextView_text_right)
        val normalBackground = typedArray.getDrawable(R.styleable.EditTextView_un_focus_bg_drawable)
        val focusBackground = typedArray.getDrawable(R.styleable.EditTextView_focus_bg_drawable)
        val marginRight = typedArray.getDimension(R.styleable.EditTextView_margin_right_content, 32f)
        val layoutEditTextParams = edtEditTextUserName?.layoutParams as LayoutParams
        if (textRight != null) {
            layoutEditTextParams.setMargins(0, 0, marginRight.toInt(), 0)
        }
        edtEditTextUserName?.layoutParams = layoutEditTextParams

        edtEditTextUserName?.setText(content)
        edtEditTextUserName?.hint = hint
        if (textRight != null) {
            tvEditTextTime?.visibility = VISIBLE
            tvEditTextTime?.text = textRight
        }
        //background
        if (normalBackground != null) frlEditText?.background = normalBackground
        frlEditText?.setBackgroundResource(R.drawable.shape_corner_4_gray_stroke)
        edtEditTextUserName?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                if (focusBackground != null) frlEditText?.background = focusBackground
                frlEditText?.setBackgroundResource(R.drawable.shape_corner_4_blue_stroke)
            } else {
                if (normalBackground != null) frlEditText?.background = normalBackground
                frlEditText?.setBackgroundResource(R.drawable.shape_corner_4_gray_stroke)
            }
        }
        edtEditTextUserName?.addTextChangedListener {
            onTextChange?.invoke(it.toString())
        }

        //button
        val textRightOtp = typedArray.getString(R.styleable.EditTextView_text_button)
        if (textRightOtp != null) {
            tvEditTextOtp?.visibility = VISIBLE
            tvEditTextOtp?.text = textRightOtp
        }
        tvEditTextTime?.setOnClickListener {
            onOtpClick?.invoke()
        }
    }

    fun setText(text: String) {
        edtEditTextUserName?.setText(text)
    }

    fun onTextChange(callback: (String) -> Unit) {
        onTextChange = callback
    }

    fun onOtpClick(callback: () -> Unit) {
        onOtpClick = callback
    }

    fun setOtpText(text: String) {
        tvEditTextOtp?.text = text
    }

    fun setTimer(text: String) {
        tvEditTextTime?.text = text
    }

    fun setHint(text: String) {
        edtEditTextUserName?.hint = text
    }
}
