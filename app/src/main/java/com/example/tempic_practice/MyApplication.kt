package com.example.tempic_practice

import android.app.Application
import com.example.tempic_practice.common.setApplication

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setApplication(this)
    }
}