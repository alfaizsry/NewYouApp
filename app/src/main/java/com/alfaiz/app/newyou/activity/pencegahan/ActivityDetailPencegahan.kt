package com.alfaiz.app.newyou.activity.pencegahan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.loadAny
import com.alfaiz.app.newyou.data.Item
import com.alfaiz.app.newyou.databinding.ActivityDetailPencegahanBinding

class ActivityDetailPencegahan : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPencegahanBinding

    companion object{
        const val EXTRA_PRODUCT = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPencegahanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pencegahanDetail = intent.getParcelableExtra<Item>(EXTRA_PRODUCT)
        binding.tvImagePencegahan.loadAny(pencegahanDetail?.image)
        binding.tvNamePencegahan.text = pencegahanDetail?.name
        binding.tvDetailPencegahan.text = pencegahanDetail?.detail
    }
}