package com.fauzanfadhlulbarr.travelin.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.fauzanfadhlulbarr.travelin.PayNowActivity
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.Walktrought1
import com.fauzanfadhlulbarr.travelin.checkout.adapter.CheckoutAdapter
import com.fauzanfadhlulbarr.travelin.home.HomeActivity
import com.fauzanfadhlulbarr.travelin.model.Palace
import com.fauzanfadhlulbarr.travelin.model.checkout
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlin.collections.ArrayList

class CheckoutActivity : AppCompatActivity() {

    private var dataList = ArrayList<checkout>()
    private var total:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        supportActionBar!!.hide()


        dataList = intent.getSerializableExtra("data") as ArrayList<checkout>

        for (a in dataList.indices){
            total += dataList[a].harga!!.toInt()
        }

        dataList.add(checkout("Total Harus Dibayar", total.toString()))

        rv_checkout.layoutManager = LinearLayoutManager(this)
        rv_checkout.adapter = CheckoutAdapter(dataList) {
        }
    }

    fun success(view: View?) {
        val intent = Intent(this, PayNowActivity::class.java)
        startActivity(intent)
    }
}