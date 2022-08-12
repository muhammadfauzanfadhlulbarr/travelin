package com.fauzanfadhlulbarr.travelin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashGetStarted : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_get_started)
        supportActionBar!!.hide()
    }

    fun GetStarted(view: View?) {
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
    }
}