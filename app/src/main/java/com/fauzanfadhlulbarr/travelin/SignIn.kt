package com.fauzanfadhlulbarr.travelin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar!!.hide()
    }

    fun SignInSuccess(view: View?) {
        val intent = Intent(this, DetailActivity()::class.java)
        startActivity(intent)
    }

    fun SignUp(view: View?) {
        val intent = Intent(this, SignUp()::class.java)
        startActivity(intent)
    }
}