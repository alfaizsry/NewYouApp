package com.alfaiz.app.newyou.activity.pencegahan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alfaiz.app.newyou.adapter.PencegahanAdapter
import com.alfaiz.app.newyou.data.DummyPencegahan
import com.alfaiz.app.newyou.data.Item
import com.alfaiz.app.newyou.databinding.ActivityPencegahanBinding
import com.alfaiz.app.newyou.iface.OnItemClickCallback
import splitties.activities.start

class ActivityPencegahan : AppCompatActivity() {

    private lateinit var activityPencegahanBinding: ActivityPencegahanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPencegahanBinding = ActivityPencegahanBinding.inflate(layoutInflater)
        setContentView(activityPencegahanBinding.root)

        showPencegahanList()
    }

    private fun showPencegahanList() {
        with(activityPencegahanBinding) {
            recyclerViewPencegahanList.setHasFixedSize(true)
            recyclerViewPencegahanList.layoutManager =
                LinearLayoutManager(this@ActivityPencegahan, RecyclerView.VERTICAL, false)
            val pencegahanAdapter =
                PencegahanAdapter(DummyPencegahan.getAll())
            recyclerViewPencegahanList.adapter = pencegahanAdapter

            pencegahanAdapter.setOnItemClickCallback(object :
                OnItemClickCallback {
                override fun onItemClick(item: Item) {
                    showSelectedPencegahan(item)
                }
            })
        }
    }

    private fun showSelectedPencegahan(pencegahan: Item) {
        start<ActivityDetailPencegahan> {
            putExtra(ActivityDetailPencegahan.EXTRA_PRODUCT, pencegahan)
        }
    }
}