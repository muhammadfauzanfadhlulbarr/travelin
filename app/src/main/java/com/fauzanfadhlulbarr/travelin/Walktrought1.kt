package com.fauzanfadhlulbarr.travelin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Walktrought1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktrought1)
        supportActionBar!!.hide()
    }

    fun NextWaltrought2(view: View?) {
        val intent = Intent(this, Walktrought2::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }
    fun BackWaltrought(view: View?) {
        val intent = Intent(this, Walktrought::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }
}