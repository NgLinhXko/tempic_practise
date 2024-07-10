package com.example.tempic_practice.presentation.widget.bottommainview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tempic_practice.R

class BottomMainView constructor(ctx: Context, attrs: AttributeSet) : LinearLayout(ctx, attrs) {

    private var rvBottomMain: RecyclerView? = null
    private val bottomMainAdapter: BottomMainAdapter by lazy {
        BottomMainAdapter()
    }

    init {
        LayoutInflater.from(ctx).inflate(R.layout.bototm_main_view, this, true)
        initView(ctx, attrs)
    }

    fun initView(ctx: Context, attrs: AttributeSet?) {
        rvBottomMain = findViewById(R.id.rvBottomMain)
        rvBottomMain?.layoutManager =
            GridLayoutManager(ctx, 5, GridLayoutManager.VERTICAL, false)
        rvBottomMain?.adapter = bottomMainAdapter
    }

}