package com.alfaiz.app.newyou

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfaiz.app.newyou.activity.ActivitySelengkapnya
import com.alfaiz.app.newyou.activity.gejala.ActivityDetailGejala
import com.alfaiz.app.newyou.activity.gejala.ActivityGejala
import com.alfaiz.app.newyou.activity.pencegahan.ActivityDetailPencegahan
import com.alfaiz.app.newyou.activity.pencegahan.ActivityPencegahan
import com.alfaiz.app.newyou.adapter.GejalaAdapter
import com.alfaiz.app.newyou.adapter.PencegahanAdapter
import com.alfaiz.app.newyou.data.DummyGejala
import com.alfaiz.app.newyou.data.DummyPencegahan
import com.alfaiz.app.newyou.data.Item
import com.alfaiz.app.newyou.databinding.ActivityMainBinding
import com.alfaiz.app.newyou.iface.OnItemClickCallback
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import splitties.activities.start

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        showRecycleList()

        getCovidData()

        tvGejalaSelengkapnya.setOnClickListener {
            var intent = Intent(this, ActivityGejala::class.java)
            startActivity(intent)
        }

        btnKnowMore.setOnClickListener {
            var intent = Intent(this, ActivitySelengkapnya::class.java)
            startActivity(intent)
        }

        tvViewPencegahanSelengkapnya.setOnClickListener {
            var intent = Intent(this, ActivityPencegahan::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("WrongConstant")
    private fun showRecycleList(){
        with(activityMainBinding){
            recyclerViewGejala.setHasFixedSize(true)
            recyclerViewGejala.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.HORIZONTAL, false)
            val gejalaAdapter = GejalaAdapter(DummyGejala.getSome())
            recyclerViewGejala.adapter = gejalaAdapter

            gejalaAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClick(gejala: Item) {
                    showSelectedGejala(gejala)
                }
            })

            recyclerViewPencegahan.setHasFixedSize(true)
            recyclerViewPencegahan.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.HORIZONTAL,false)
            val pencegahanAdapter = PencegahanAdapter(DummyPencegahan.getSome())
            recyclerViewPencegahan.adapter = pencegahanAdapter

            pencegahanAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClick(pencegahan: Item) {
                    showSelectedPencegahan(pencegahan)
                }
            })

        }
    }

    private fun showSelectedGejala(gejala: Item){
        start<ActivityDetailGejala>{
            putExtra(ActivityDetailGejala.EXTRA_PRODUCT, gejala)
        }
    }
    private fun showSelectedPencegahan(pencegahan: Item){
        start<ActivityDetailPencegahan>{
            putExtra(ActivityDetailPencegahan.EXTRA_PRODUCT, pencegahan)
        }
    }

    private fun getCovidData(){
        val url = "https://disease.sh/v3/covid-19/all"

        val stringRequest = StringRequest(
                Request.Method.GET,
                url,
            {
                var jsonObject = JSONObject(it.toString())

                txtKasus.text = jsonObject.getString("cases")
                txtSembuh.text = jsonObject.getString("recovered")
                txtMeninggal.text = jsonObject.getString("deaths")
            },
            {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                txtKasus.text = "_____"
                txtSembuh.text = "_____"
                txtMeninggal.text = "_____"
            }
        )

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}