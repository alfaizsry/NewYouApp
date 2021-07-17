package com.alfaiz.app.newyou.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alfaiz.app.newyou.R
import kotlinx.android.synthetic.main.activity_selengkapnya.*

class ActivitySelengkapnya : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selengkapnya)

        btnLearnMore.setOnClickListener {
            var intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19")
            )
            startActivity(intent)
        }
    }
}