package com.alfaiz.app.newyou

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.loadAny
import com.alfaiz.app.newyou.data.Item
import com.alfaiz.app.newyou.databinding.ItemGejalaBinding

class GejalaAdapter(private var gejalaList: MutableList<Item>):
    RecyclerView.Adapter<GejalaAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GejalaAdapter.ViewHolder {
        return ViewHolder(
            ItemGejalaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class ViewHolder(private val binding: ItemGejalaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gejala: Item) {
            with(binding) {
                tvImageGejala.loadAny(gejala.image)
                tvNameGejala.text = gejala.name
                tvDetailGejala.text = gejala.detail

                itemView.setOnClickListener { onItemClickCallback?.onItemClick(gejala) }
            }
        }
    }

    override fun getItemCount(): Int = gejalaList.size

    override fun onBindViewHolder(holder: GejalaAdapter.ViewHolder, position: Int) {
        holder.bind(gejalaList[position])
    }

}