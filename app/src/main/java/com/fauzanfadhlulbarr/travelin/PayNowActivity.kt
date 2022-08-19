package com.fauzanfadhlulbarr.travelin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fauzanfadhlulbarr.travelin.home.HomeActivity

class PayNowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_now)
        supportActionBar!!.hide()


    }

    fun history(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun homepage(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}