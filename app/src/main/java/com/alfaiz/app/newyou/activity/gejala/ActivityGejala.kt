package com.alfaiz.app.newyou.activity.gejala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alfaiz.app.newyou.adapter.GejalaAdapter
import com.alfaiz.app.newyou.data.DummyGejala
import com.alfaiz.app.newyou.data.Item
import com.alfaiz.app.newyou.databinding.ActivityGejalaBinding
import com.alfaiz.app.newyou.iface.OnItemClickCallback
import splitties.activities.start

class ActivityGejala : AppCompatActivity() {

    private lateinit var activityGejalaBinding: ActivityGejalaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityGejalaBinding = ActivityGejalaBinding.inflate(layoutInflater)
        setContentView(activityGejalaBinding.root)

        showGejalaList()
    }

    private fun showGejalaList() {
        with(activityGejalaBinding) {
            recyclerViewGejalaList.setHasFixedSize(true)
            recyclerViewGejalaList.layoutManager =
                LinearLayoutManager(this@ActivityGejala, RecyclerView.VERTICAL, false)
            val gejalaAdapter =
                GejalaAdapter(DummyGejala.getAll())
            recyclerViewGejalaList.adapter = gejalaAdapter

            gejalaAdapter.setOnItemClickCallback(object :
                OnItemClickCallback {
                override fun onItemClick(item: Item) {
                    showSelectedGejala(item)
                }
            })
        }
    }

    private fun showSelectedGejala(gejala: Item) {
        start<ActivityDetailGejala> {
            putExtra(ActivityDetailGejala.EXTRA_PRODUCT, gejala)
        }
    }
}