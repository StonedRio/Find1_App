package com.example.find1app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.find1app.R
import com.example.find1app.model.ResultsInstitution

class ResultsAdapter(private val itemList: List<ResultsInstitution>)
    : RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {


    // onClick
    var onItemClick: ((ResultsInstitution) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.results_cardview, parent, false)
        return ResultsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)

// onclick
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val institutionNameTextView: TextView = itemView.findViewById(R.id.tv_institute_name)
        private val locationTextView: TextView = itemView.findViewById(R.id.tv_location)
        private val eduTypeTextView: TextView = itemView.findViewById(R.id.tv_edu_type)
        private val rating: TextView = itemView.findViewById(R.id.tvTotalRating)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        private val transportCheckBox: CheckBox = itemView.findViewById(R.id.checkbox_transport)
        private val playAreaCheckBox: CheckBox = itemView.findViewById(R.id.checkbox_play_area)


        fun bind(item: ResultsInstitution) {
            institutionNameTextView.text = item.institutionName
            locationTextView.text = item.location
            eduTypeTextView.text = item.educationType
            rating.text = item.rating.toString()
            ratingBar.rating = item.rating.toFloat()
            transportCheckBox.isChecked = item.transport
            playAreaCheckBox.isChecked = item.playArea
        }
    }
}