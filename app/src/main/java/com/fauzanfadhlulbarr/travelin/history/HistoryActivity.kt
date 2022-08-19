package com.fauzanfadhlulbarr.travelin.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.history.adapter.HistoryAdapter
import com.fauzanfadhlulbarr.travelin.model.Palace
import com.fauzanfadhlulbarr.travelin.model.checkout
import kotlinx.android.synthetic.main.activity_history2.*

class HistoryActivity : AppCompatActivity() {

    private var dataList = ArrayList<checkout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history2)
        supportActionBar!!.hide()

        val data = intent.getParcelableExtra<Palace>("data")

        tv_city_history.text = data!!.city
        tv_place_history.text = data!!.namakota
        tv_rate_history.text = data!!.rating

        Glide.with(this)
            .load(data!!.imageUrl)
            .into(images_history)

        rc_history.layoutManager = LinearLayoutManager(this)
        dataList.add(checkout("A1",""))
        dataList.add(checkout("B1",""))

        rc_history.adapter = HistoryAdapter(dataList) {
        }


    }


}