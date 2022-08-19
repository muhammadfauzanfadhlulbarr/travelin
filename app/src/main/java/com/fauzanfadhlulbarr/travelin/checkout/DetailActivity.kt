package com.fauzanfadhlulbarr.travelin.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.model.Palace
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.hide()

        book_now_detail.setOnClickListener {
            val intent = Intent(this,
                ChooseSeat::class.java)
            startActivity(intent)
        }

        val data = intent.getParcelableExtra<Palace>("data")

        tv_about_detail.text = data!!.desc
        tv_city_detail.text = data!!.city
        tv_place_detail.text = data!!.namakota
        price_detail.text = data!!.harga

        Glide.with(this)
            .load(data.imageUrl)
            .into(images_detail)


    }
}