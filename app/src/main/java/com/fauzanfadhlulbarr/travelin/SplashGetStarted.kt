package com.fauzanfadhlulbarr.travelin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fauzanfadhlulbarr.travelin.utils.Preference
import kotlinx.android.synthetic.main.splash_get_started.*

class SplashGetStarted : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_get_started)

        getstarted.setOnClickListener{
                val intent = Intent(this, Walktrought::class.java)
                startActivity(intent)
        }
        supportActionBar!!.hide()
    }



}