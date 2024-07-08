package com.example.tempic_practice.presentation.widget.header

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.tempic_practice.R

class HeaderView constructor(ctx: Context, attrs: AttributeSet?) : FrameLayout(ctx, attrs) {
    private var frlHeader: FrameLayout? = null
    private var ivHeaderRight: AppCompatImageView? = null
    private var ivHeaderLeft: AppCompatImageView? = null
    private var tvHeaderTitle: AppCompatTextView? = null

    //callback
    private var onLeftClick: (() -> Unit)? = null
    private var onRightClick: (() -> Unit)? = null

    init {
        LayoutInflater.from(ctx).inflate(R.layout.header_view, this, true)
        initView(ctx, attrs)
    }

    fun initView(context: Context, attrs: AttributeSet?) {
        frlHeader = findViewById(R.id.frlHeader)
        ivHeaderRight = findViewById(R.id.ivHeaderRight)
        ivHeaderLeft = findViewById(R.id.ivHeaderLeft)
        tvHeaderTitle = findViewById(R.id.tvHeader)

        //type array
        val typeArray = context.theme.obtainStyledAttributes(attrs, R.styleable.HeaderView, 0, 0)
        //icon left
        var iconLeft = typeArray.getResourceId(R.styleable.HeaderView_ic_hv_left, 0)
        if (iconLeft != 0 && ivHeaderLeft != null) {
            ivHeaderLeft?.visibility = VISIBLE
            ivHeaderLeft?.setImageResource(iconLeft)
            ivHeaderLeft?.setOnClickListener {
                onLeftClick?.invoke()
            }
        }
        //icon right
        var iconRight = typeArray.getResourceId(R.styleable.HeaderView_ic_hv_right, 0)
        if (iconRight != 0 && ivHeaderRight != null) {
            ivHeaderRight?.visibility = VISIBLE
            ivHeaderRight?.setImageResource(iconRight)
            ivHeaderRight?.setOnClickListener {
                onRightClick?.invoke()
            }
        }
        //title
        var title = typeArray.getString(R.styleable.HeaderView_text_header)
        if (title != null && tvHeaderTitle != null) {
            tvHeaderTitle?.text = title
        }
    }

    fun setOnLeftClick(onLeftClick: () -> Unit) {
        this.onLeftClick = onLeftClick
    }

    fun setOnRightClick(onRightClick: () -> Unit) {
        this.onRightClick = onRightClick
    }

    fun setTitle(title: String) {
        tvHeaderTitle?.text = title
    }

    fun setIconLeft(icon: Int) {
        ivHeaderLeft?.setImageResource(icon)
    }

    fun setIconRight(icon: Int) {
        ivHeaderRight?.setImageResource(icon)
    }
}
