package com.example.find1app.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.find1app.R
import com.example.find1app.model.FeaturedInstitution
import com.example.find1app.model.city

class BrowseByCitiesAdapter(private val itemList: List<city>) : RecyclerView.Adapter<BrowseByCitiesAdapter.BrowseByCitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseByCitiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.browse_by_cities_cardview, parent, false)
        return BrowseByCitiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrowseByCitiesViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class BrowseByCitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cityNameTextView: TextView = itemView.findViewById(R.id.city_name)

        fun bind(item: city) {
            cityNameTextView.text = item.cityName
        }
    }
}
