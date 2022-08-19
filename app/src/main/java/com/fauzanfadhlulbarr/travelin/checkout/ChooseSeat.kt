package com.fauzanfadhlulbarr.travelin.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.model.Palace
import com.fauzanfadhlulbarr.travelin.model.checkout
import kotlinx.android.synthetic.main.activity_choose_seat.*

class ChooseSeat : AppCompatActivity() {

    var statusA1:Boolean = false
    var statusB1:Boolean = false
    var statusC1:Boolean = false
    var statusD1:Boolean = false
    var total:Int = 0

    private var dataList = ArrayList<checkout>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_seat)
        supportActionBar!!.hide()

        val data = intent.getParcelableExtra<Palace>("data")

        a1.setOnClickListener {
            if (statusA1) {
                a1.setImageResource(R.drawable.background_available)
                statusA1 = false
                total -= 1
                buySeat(total)

                // delete data
                dataList.remove(checkout("A1", "3500000"))

            } else {
                a1.setImageResource(R.drawable.background_selected)
                statusA1 = true
                total +=1
                buySeat(total)

                val data = checkout("A1", "3500000")
                dataList.add(data)
            }
        }
        b1.setOnClickListener {
            if (statusB1) {
                b1.setImageResource(R.drawable.background_available)
                statusB1 = false
                total -= 1
                buySeat(total)

                // delete data
                dataList.remove(checkout("B1", "3500000"))

            } else {
                b1.setImageResource(R.drawable.background_selected)
                statusB1 = true
                total +=1
                buySeat(total)

                val data = checkout("B1", "3500000")
                dataList.add(data)
            }
        }
        c1.setOnClickListener {
            if (statusC1) {
                c1.setImageResource(R.drawable.background_available)
                statusC1 = false
                total -= 1
                buySeat(total)

                // delete data
                dataList.remove(checkout("C1", "3500000"))

            } else {
                c1.setImageResource(R.drawable.background_selected)
                statusC1 = true
                total +=1
                buySeat(total)

                val data = checkout("C1", "3500000")
                dataList.add(data)
            }
        }
        d1.setOnClickListener {
            if (statusD1) {
                b1.setImageResource(R.drawable.background_available)
                statusD1 = false
                total -= 1
                buySeat(total)

                // delete data
                dataList.remove(checkout("D1", "3500000"))

            } else {
                b1.setImageResource(R.drawable.background_selected)
                statusD1 = true
                total +=1
                buySeat(total)

                val data = checkout("D1", "3500000")
                dataList.add(data)
            }
        }

        btn_checkout.setOnClickListener {
            val intent = Intent(
                this,
                CheckoutActivity::class.java
            ).putExtra("data", dataList).putExtra("datas", data)
            startActivity(intent)
        }
    }

    private fun buySeat(total: Int) {
        if (total == 0) {
            btn_checkout.setText("Beli Tiket")
            btn_checkout.visibility = View.INVISIBLE
        } else {
            btn_checkout.setText("Beli Tiket ("+total+")")
            btn_checkout.visibility = View.VISIBLE
        }


    }
}