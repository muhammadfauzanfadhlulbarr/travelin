package com.fauzanfadhlulbarr.travelin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fauzanfadhlulbarr.travelin.utils.Preference

class Walktrought : AppCompatActivity() {
    lateinit var preference: Preference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktrought)
        preference = Preference(this)


        if (preference.getValues("getstarted").equals("1")){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        supportActionBar!!.hide()
    }

    fun NextWaltrought1(view: View?) {
        val intent = Intent(this, Walktrought1::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

}