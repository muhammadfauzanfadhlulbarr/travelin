package com.fauzanfadhlulbarr.travelin.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fauzanfadhlulbarr.travelin.home.HomeActivity
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.signup.SignUp
import com.fauzanfadhlulbarr.travelin.utils.Preference
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignIn : AppCompatActivity() {

    lateinit var iUsername:String
    lateinit var iPassword:String

    lateinit var mDatabase: DatabaseReference
    lateinit var preferences: Preference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preference(this)

        preferences.setValues("getstarted", "1")
        btn_signin.setOnClickListener {
            iUsername = et_username.text.toString()
            iPassword = et_password.text.toString()

            if (iUsername.equals("")) {
                et_username.error = "Silahkan tulis Username Anda"
                et_username.requestFocus()
            } else if (iPassword.equals("")) {
                et_password.error = "Silahkan tulis Password Anda"
                et_password.requestFocus()
            } else {

                var statusUsername = iUsername.indexOf(".")
                if (statusUsername >=0) {
                    et_username.error = "Silahkan tulis Username Anda tanpa ."
                    et_username.requestFocus()
                } else {
                    pushLogin(iUsername, iPassword)
                }
            }

        }
        btn_signup.setOnClickListener {
            val intent = Intent(this@SignIn,
                SignUp::class.java)
            startActivity(intent)
        }


        supportActionBar!!.hide()


    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    Toast.makeText(this@SignIn, "User tidak ditemukan", Toast.LENGTH_LONG).show()

                } else {
                    if (user.password.equals(iPassword)){
                        Toast.makeText(this@SignIn, "Selamat Datang", Toast.LENGTH_LONG).show()

                        preferences.setValues("nama", user.nama.toString())
                        preferences.setValues("username", user.username.toString())
                        preferences.setValues("email", user.email.toString())
                        preferences.setValues("saldo", user.saldo.toString())
                        preferences.setValues("status", "1")

                        finishAffinity()

                        val intent = Intent(this@SignIn,
                            HomeActivity::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this@SignIn, "Password Anda Salah", Toast.LENGTH_LONG).show()
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignIn, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }


}