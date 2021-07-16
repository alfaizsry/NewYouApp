package com.alfaiz.app.newyou.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.loadAny
import com.alfaiz.app.newyou.iface.OnItemClickCallback
import com.alfaiz.app.newyou.data.Item
import com.alfaiz.app.newyou.databinding.ItemPencegahanBinding

class PencegahanAdapter(private var pencegahanList: MutableList<Item>):
    RecyclerView.Adapter<PencegahanAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(private val binding: ItemPencegahanBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(pencegahan: Item) {
            with(binding){
                tvImagePencegahan.loadAny(pencegahan.image)
                tvNamePencegahan.text = pencegahan.name
                tvDetailPencegahan.text = pencegahan.detail

                itemView.setOnClickListener { onItemClickCallback?.onItemClick(pencegahan) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPencegahanBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = pencegahanList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pencegahanList[position])
    }
}