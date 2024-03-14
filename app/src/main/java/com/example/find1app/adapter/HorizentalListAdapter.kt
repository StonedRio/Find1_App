package com.example.find1app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.find1app.R

class HorizontalListAdapter(private val items: List<String>) : RecyclerView.Adapter<HorizontalListAdapter.ViewHolder>() {

    private var selectedItemIndex = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], position == selectedItemIndex)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    selectedItemIndex = position
                    notifyDataSetChanged()
                }
            }
        }

        fun bind(text: String, isSelected: Boolean) {
            textView.text = text
            if (isSelected) {
                textView.setBackgroundResource(R.drawable.selected_background)
                textView.setTextColor(R.color.white)
            } else {
                textView.setBackgroundResource(R.drawable.white_round_background)

                textView.setTextColor(R.color.black)
            }
        }
    }
}
