package com.example.tempic_practice.domain.model

import com.example.tempic_practice.R

data class BottomMain(
    var id: Int = 0,
    var icon: Int = 0,
    var isSelected: Boolean = false
)

fun fakeListBottomMain(): MutableList<BottomMain> {
    val list = mutableListOf<BottomMain>()
    for (i in 0..4) {
        list.add(BottomMain(i, R.drawable.ic_home, i == 0))
    }

    return list
}