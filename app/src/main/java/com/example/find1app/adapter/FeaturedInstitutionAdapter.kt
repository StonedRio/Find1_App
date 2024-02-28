package com.example.find1app.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.find1app.R
import com.example.find1app.model.FeaturedInstitution

class FeaturedInstitutionAdapter(private val itemList: List<FeaturedInstitution>) :
    RecyclerView.Adapter<FeaturedInstitutionAdapter.FeaturedInstitutionViewHolder>() {

    var onItemClick: ((FeaturedInstitution) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedInstitutionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.featured_institution_cardview, parent, false)
        return FeaturedInstitutionViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeaturedInstitutionViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class FeaturedInstitutionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val institutionNameTextView: TextView = itemView.findViewById(R.id.institution_name)
        private val ratingTextView: TextView = itemView.findViewById(R.id.rating_count)
        private val startingFeeTextView: TextView = itemView.findViewById(R.id.starting_from)

        fun bind(item: FeaturedInstitution) {
            institutionNameTextView.text = item.institutionName
            ratingTextView.text = "("+item.rating.toString()+")"
            startingFeeTextView.text = item.startingFee
        }
    }
}
