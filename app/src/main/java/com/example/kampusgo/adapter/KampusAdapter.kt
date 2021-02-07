package com.example.kampusgo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kampusgo.model.Kampus
import com.example.kampusgo.R
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item_kampus.view.*

class KampusAdapter(
        var kampuses: List<Kampus>
) : RecyclerView.Adapter<KampusAdapter.KampusViewHolder>() {

    inner class KampusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KampusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kampus, parent, false)
        return KampusViewHolder(view)
    }

    override fun onBindViewHolder(holder: KampusViewHolder, position: Int) {
        var item = kampuses?.get(position)

        holder.itemView.apply {
            tvTitle.text = kampuses[position].nama_kampus
            btnPilih.setOnClickListener {
                onItemClickListener?.let {
                    it(item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return kampuses.size
    }

    private var onItemClickListener: ((Kampus) -> Unit)? = null

    fun setOnClickListener(listener: (Kampus) -> Unit) {
        onItemClickListener = listener
    }

}