package com.example.tempic_practice.presentation.widget.bottommainview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.tempic_practice.R
import com.example.tempic_practice.common.getAppColor
import com.example.tempic_practice.domain.model.BottomMain
import com.example.tempic_practice.domain.model.fakeListBottomMain

class BottomMainAdapter : Adapter<BottomMainAdapter.BottomMainViewHolder>() {

    var lBottomMain: MutableList<BottomMain> = fakeListBottomMain()

    inner class BottomMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivBottomMainIcon: AppCompatImageView? = null

        init {
            ivBottomMainIcon = itemView.findViewById(R.id.ivBottomMainItmIcon)
            ivBottomMainIcon?.setOnClickListener {
                lBottomMain[adapterPosition].isSelected = !lBottomMain[adapterPosition].isSelected
                notifyDataSetChanged()
            }
        }

        fun bind(bottomMain: BottomMain) {
            ivBottomMainIcon?.setImageResource(bottomMain.icon)
            if (bottomMain.isSelected) {
                ivBottomMainIcon?.setImageResource(R.drawable.ic_person_active)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomMainViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.bottom_main_item, parent, false)
        return BottomMainViewHolder(view)
    }

    override fun getItemCount(): Int = lBottomMain.size

    override fun onBindViewHolder(holder: BottomMainViewHolder, position: Int) {
        holder.bind(lBottomMain[position])
    }
}