package com.joaovictor.firebaseauthgoogle.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.joaovictor.firebaseauthgoogle.R
import com.joaovictor.firebaseauthgoogle.model.Ride
import com.joaovictor.firebaseauthgoogle.adapter.RideAdapter
import kotlinx.android.synthetic.main.column_recycler.*
import kotlinx.android.synthetic.main.fragment_rides_list.*

class ListRideFragment: Fragment() {

    private lateinit var database: DatabaseReference
    private lateinit var ridesList: ArrayList<Ride>
    private lateinit var adapter: RideAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_rides_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        view?.let {
            database = FirebaseDatabase.getInstance().getReference("")
            loadData()
        }

    }


    private fun loadData() {
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                i("onCancelled", error.toString())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                ridesList = ArrayList()
                var total = 0.0f

                for (snapshot in dataSnapshot.children) {
                    i("onDataChange", snapshot.toString())
                     val ride = snapshot.getValue(Ride::class.java)
                    ridesList.add(ride!!)

                    ride.let {
                        total += it.value!!
                        val formatted = "R$$total"
                        amount_text.text = formatted
                    }
                }
                setUpRecyclerView()
            }
        })
    }

    private fun setUpRecyclerView() {
        ridesList.let {
            adapter = RideAdapter(it)
            recycler_rides.adapter = adapter
            recycler_rides.layoutManager = LinearLayoutManager(activity)
        }

    }



}