package com.fauzanfadhlulbarr.travelin.checkout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.model.checkout
import java.text.NumberFormat
import java.util.*

class CheckoutAdapter(private var data: List<checkout>,
                      private val listener: (checkout) -> Unit)
    : RecyclerView.Adapter<CheckoutAdapter.LeagueViewHolder>() {
    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.row_item_checkout, parent, false)

        return LeagueViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.co_seat)
        private val tvHarga: TextView = view.findViewById(R.id.co_harga)


        fun bindItem(
            data: checkout,
            listener: (checkout) -> Unit,
            context: Context,
        ) {


            val localeID = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
            tvHarga.setText(formatRupiah.format(data.harga!!.toDouble()))

            if (data.seat!!.startsWith("Total")) {
                tvTitle.text = data.seat
                tvTitle.setCompoundDrawables(null, null, null, null)
            } else {
                tvTitle.text = "Seat No. " + data.seat
            }

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

    }