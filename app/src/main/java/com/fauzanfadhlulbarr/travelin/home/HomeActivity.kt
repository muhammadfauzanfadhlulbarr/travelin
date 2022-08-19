package com.fauzanfadhlulbarr.travelin.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fauzanfadhlulbarr.travelin.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()

        val framentHome = DashboardFragment()

        setFragment(framentHome)

        menu_1.setOnClickListener {
            setFragment(framentHome)
            menu_1.setColorFilter(resources.getColor(R.color.PrimaryColor))
        }

        menu_2.setOnClickListener {
            setFragment(framentHome)
            menu_2.setColorFilter(resources.getColor(R.color.PrimaryColor))
        }

        menu_3.setOnClickListener {
            setFragment(framentHome)
            menu_3.setColorFilter(resources.getColor(R.color.PrimaryColor))
        }

        menu_4.setOnClickListener {
            setFragment(framentHome)
            menu_4.setColorFilter(resources.getColor(R.color.PrimaryColor))
        }

    }

    private fun setFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framehome, fragment)
        fragmentTransaction.commit()
    }


}