package com.fauzanfadhlulbarr.travelin.history

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fauzanfadhlulbarr.travelin.R
import com.fauzanfadhlulbarr.travelin.dashboard.NewThisYearAdapter
import com.fauzanfadhlulbarr.travelin.model.Palace
import com.fauzanfadhlulbarr.travelin.utils.Preference
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {
    private lateinit var preference: Preference
    private lateinit var mDatabase :DatabaseReference
    private var datalist = ArrayList<Palace>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preference = Preference(requireActivity().applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("Palace")

        rc_booking.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        getData()

    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                datalist.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {

                    val palace = getdataSnapshot.getValue(Palace::class.java!!)
                    datalist.add(palace!!)
                }

                rc_booking.adapter = NewThisYearAdapter(datalist) {
                    val intent = Intent(context,
                        HistoryActivity::class.java).putExtra("data", it)
                    startActivity(intent)
                }

                tv_total.setText(datalist.size.toString() +" Palace")

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}