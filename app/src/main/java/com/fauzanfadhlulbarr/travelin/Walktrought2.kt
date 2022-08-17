package com.fauzanfadhlulbarr.travelin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Walktrought2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktrought2)
        supportActionBar!!.hide()
    }


    fun NextSignIn(view: View?) {
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }
    fun BackWaltrought1(view: View?) {
        val intent = Intent(this, Walktrought1::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }
}