package com.fauzanfadhlulbarr.travelin.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.model.Palace

class NowPlayingAdapter(private var data: List<Palace>,
                        private val listener: (Palace) -> Unit)
    : RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {

    lateinit var contextAdapter: android.content.Context

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int)
    : NowPlayingAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.row_item_palace, parent, false)

        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: NowPlayingAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter, position)
    }

    override fun getItemCount(): Int = data.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvPlace: TextView = view.findViewById(R.id.tv_place)
        private val tvCity: TextView = view.findViewById(R.id.tv_city)
        private val tvRate: TextView = view.findViewById(R.id.tv_rate)

        private val tvImage: ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data: Palace, listener: (Palace) -> Unit, context : android.content.Context, position : Int) {

            tvPlace.text = data.city
            tvCity.text = data.namakota
            tvRate.text = data.rating

            Glide.with(context)
                .load(data.imageUrl)
                .into(tvImage);

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }


}
