package com.alfaiz.app.newyou.activity.gejala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.loadAny
import com.alfaiz.app.newyou.data.Item
import com.alfaiz.app.newyou.databinding.ActivityDetailGejalaBinding

class ActivityDetailGejala : AppCompatActivity() {

    private lateinit var binding: ActivityDetailGejalaBinding

    companion object{
        const val EXTRA_PRODUCT = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGejalaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gejalaDetail = intent.getParcelableExtra<Item>(EXTRA_PRODUCT)
        binding.tvImageGejala.loadAny(gejalaDetail?.image)
        binding.tvNameGejala.text = gejalaDetail?.name
        binding.tvDetailGejala.text = gejalaDetail?.detail
    }
}