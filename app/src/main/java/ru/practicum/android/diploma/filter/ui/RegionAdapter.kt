package ru.practicum.android.diploma.filter.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.practicum.android.diploma.R
import ru.practicum.android.diploma.filter.domain.models.Region

class RegionAdapter(
    private val onClick: (region: Region) -> Unit
) : RecyclerView.Adapter<RegionViewHolder>() {

    private var regions = listOf<Region>()
    fun update(newRegions: List<Region>) {
        regions = newRegions
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return RegionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        holder.bind(regions[position], onClick)
    }

    override fun getItemCount() = regions.size
}
