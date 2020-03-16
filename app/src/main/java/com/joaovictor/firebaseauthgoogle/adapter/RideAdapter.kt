package com.joaovictor.firebaseauthgoogle.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joaovictor.firebaseauthgoogle.R
import com.joaovictor.firebaseauthgoogle.model.Ride
import kotlinx.android.synthetic.main.ride_item.view.*

class RideAdapter(val ridelist: ArrayList<Ride>):
    RecyclerView.Adapter<RideAdapter.RideViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RideViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.ride_item, parent, false)

        return RideViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ridelist.size
    }

    override fun onBindViewHolder(holder: RideViewHolder, position: Int) {
        holder.bind(ridelist[position])
    }


    inner class RideViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {

        fun bind(rides: Ride) {
            with(rides) {
                itemView.client_item.text = client
                itemView.value_item.text = value.toString()
                itemView.date_item.text = date

            }
        }

    }
}