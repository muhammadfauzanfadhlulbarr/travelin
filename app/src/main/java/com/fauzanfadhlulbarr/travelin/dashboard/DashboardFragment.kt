package com.fauzanfadhlulbarr.travelin.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fauzanfadhlulbarr.travelin.checkout.DetailActivity
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.model.Palace
import com.fauzanfadhlulbarr.travelin.utils.Preference
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var preference : Preference
    private lateinit var mDatabase: DatabaseReference

    private var dataList = ArrayList<Palace>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preference = Preference(requireActivity().applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("Palace")

        tv_nama.setText(preference.getValues("username"))


        rv_palace.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_new.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        getData()
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {

                    val palace = getdataSnapshot.getValue(Palace::class.java!!)
                    dataList.add(palace!!)
                }

                rv_palace.adapter = NowPlayingAdapter(dataList) {
                    val intent = Intent(
                        context,
                        DetailActivity::class.java
                    ).putExtra("data", it)
                    startActivity(intent)

                }

                rv_new.adapter = NewThisYearAdapter(dataList) {
                    val intent = Intent(
                        context,
                        DetailActivity::class.java
                    ).putExtra("data", it)
                    startActivity(intent)
                }

            }




        })
    }
}