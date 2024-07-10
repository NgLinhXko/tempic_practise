package com.example.tempic_practice.presentation.widget.leftrightview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.tempic_practice.R

class LeftRightView constructor(ctx: Context, attrs: AttributeSet) : FrameLayout(ctx, attrs) {
    private lateinit var ivLeftRightIconLeft: AppCompatImageView
    private lateinit var tvLeftRight: AppCompatTextView

    private var llLeftRightRoot: LinearLayout? = null

    //click
    private var onItemClick: (() -> Unit)? = null

    init {
        LayoutInflater.from(ctx).inflate(R.layout.left_right_view, this, true)
        initView(ctx, attrs)
    }

    fun initView(context: Context, attrs: AttributeSet?) {
        ivLeftRightIconLeft = findViewById(R.id.ivLeftRightIconLeft)
        tvLeftRight = findViewById(R.id.tvLeftRight)
        llLeftRightRoot = findViewById(R.id.llLeftRightRoot)
        //type array
        val typeArray = context.theme.obtainStyledAttributes(attrs, R.styleable.LeftRightView, 0, 0)
        //icon
        val icon = typeArray.getResourceId(R.styleable.LeftRightView_ic_left, 0)
        if (icon != 0) {
            ivLeftRightIconLeft.setImageResource(icon)
        }
        ivLeftRightIconLeft.setOnClickListener {
            onItemClick?.invoke()
        }
        //text
        val text = typeArray.getString(R.styleable.LeftRightView_text_center)
        if (text != null) {
            tvLeftRight.text = text
        }
        //root
        llLeftRightRoot?.setOnClickListener {
            onItemClick?.invoke()
        }
    }

    fun setOnItemClick(onItemClick: () -> Unit) {
        this.onItemClick = onItemClick
    }

    fun setIcon(icon: Int) {
        ivLeftRightIconLeft.setImageResource(icon)
    }

    fun setText(text: String) {
        tvLeftRight.text = text
    }
}
