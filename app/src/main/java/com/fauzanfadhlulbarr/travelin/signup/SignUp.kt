package com.fauzanfadhlulbarr.travelin.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fauzanfadhlulbarr.travelin.home.HomeActivity
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.signin.SignIn
import com.fauzanfadhlulbarr.travelin.signin.User
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    lateinit var sUsername:String
    lateinit var sPassword:String
    lateinit var sFullNama:String
    lateinit var sEmail:String

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance : FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar!!.hide()

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        btn_su.setOnClickListener {
            sUsername = su_username.text.toString()
            sPassword = su_password.text.toString()
            sFullNama = su_fullname.text.toString()
            sEmail = su_email.text.toString()

            if (sUsername.equals("")) {
                su_username.error = "Silahkan isi Username"
                su_username.requestFocus()
            } else if (sPassword.equals("")) {
                su_password.error = "Silahkan isi Password"
                su_password.requestFocus()
            } else if (sFullNama.equals("")) {
                su_fullname.error = "Silahkan isi Nama"
                su_fullname.requestFocus()
            } else if (sEmail.equals("")) {
                su_email.error = "Silahkan isi Email"
                su_email.requestFocus()
            } else {

                var statusUsername = sUsername.indexOf(".")
                if (statusUsername >=0) {
                    su_username.error = "Silahkan tulis Username Anda tanpa ."
                    su_username.requestFocus()
                } else {
                    saveUsername(sUsername, sPassword, sFullNama, sEmail)
                }

            }
        }
    }

    private fun saveUsername(sUsername: String, sPassword: String, sFullNama: String, sEmail: String) {
        var user = User()
        user.email = sEmail
        user.nama = sFullNama
        user.password = sPassword
        user.username = sUsername

        if (sUsername != null) {
            checkingUsername(sUsername, user)

        }

    }

    private fun checkingUsername(sUsername: String, data: User) {
        mFirebaseDatabase.child(sUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    mFirebaseDatabase.child(sUsername).setValue(data)


                    val intent = Intent(this@SignUp,
                        HomeActivity::class.java).putExtra("nama", data.nama)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@SignUp, "User sudah digunakan", Toast.LENGTH_LONG).show()

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignUp, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun GetStarted(view: View?) {
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
    }


}