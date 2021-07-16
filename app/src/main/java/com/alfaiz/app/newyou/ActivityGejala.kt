package com.alfaiz.app.newyou

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfaiz.app.newyou.data.DummyGejala
import com.alfaiz.app.newyou.data.Item
import com.alfaiz.app.newyou.databinding.ActivityGejalaBinding
import splitties.activities.start

class ActivityGejala : AppCompatActivity() {

    private lateinit var activityGejalaBinding: ActivityGejalaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityGejalaBinding = ActivityGejalaBinding.inflate(layoutInflater)
        setContentView(activityGejalaBinding.root)

        showGejalaList()
    }

    @SuppressLint("WrongConstant")
    private fun showGejalaList(){
        with(activityGejalaBinding){
            recyclerViewGejalaList.setHasFixedSize(true)
            recyclerViewGejalaList.layoutManager = LinearLayoutManager(this@ActivityGejala, LinearLayout.VERTICAL, false)
            val gejalaAdapter = GejalaAdapter(DummyGejala.getAll())
            recyclerViewGejalaList.adapter = gejalaAdapter

            gejalaAdapter.setOnItemClickCallback(object : OnItemClickCallback{
                override fun onItemClick(gejala: Item) {
                    showSelectedGejala(gejala)
                }
            })
        }
    }

    private fun showSelectedGejala(gejala: Item){
        start<ActivityDetailGejala>{
            putExtra(ActivityDetailGejala.EXTRA_PRODUCT, gejala)
        }
    }
}