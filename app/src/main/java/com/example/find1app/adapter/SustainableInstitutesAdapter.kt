package com.example.find1app.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.find1app.R
import com.example.find1app.model.FeaturedInstitution
import com.example.find1app.model.SustainableInstitute

class SustainableInstitutesAdapter(private val itemList: List<SustainableInstitute>) :
    RecyclerView.Adapter<SustainableInstitutesAdapter.SustainableInstituteViewHolder>() {
    var onItemClick: ((SustainableInstitute) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SustainableInstituteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sustainable_institutes_cardview, parent, false)
        return SustainableInstituteViewHolder(view)
    }

    override fun onBindViewHolder(holder: SustainableInstituteViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class SustainableInstituteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val institutionNameTextView: TextView = itemView.findViewById(R.id.institution_name)
        private val ratingTextView: TextView = itemView.findViewById(R.id.rating_count)
        private val progressTextview: TextView = itemView.findViewById(R.id.progress_textview)

        fun bind(item: SustainableInstitute) {
            institutionNameTextView.text = item.institutionName
            ratingTextView.text = "("+item.rating.toString()+")"
            progressTextview.text = item.progress
        }
    }
}
