package com.joaovictor.firebaseauthgoogle

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_register.*
import java.util.*

class RegisterFragment : Fragment() {

    private lateinit var database: DatabaseReference



    override fun onAttach(context: Context) {
        super.onAttach(context)

        //val db = FirebaseDatabase.getInstance().getReference("/rides")
        //fun getFirebaseInstance():FirebaseDatabase {
          //  return FirebaseDatabase.getInstance()
        //}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val rightnow: Calendar
        rightnow = Calendar.getInstance()

        val text = rightnow.get(Calendar.DAY_OF_MONTH).toString() + "/" +
                rightnow.get(Calendar.MONTH).toString() + "/" +
                rightnow.get(Calendar.YEAR).toString()

        clientTextField.setText("Guilherme")
        dateTextField.setText(text)
        valueTextField.setText("4")


        register_ride.setOnClickListener {
            writeNewUser(clientTextField.text.toString(),
                valueTextField.text.toString().toFloat(),
                dateTextField.text.toString())

        }

    }

    private fun writeNewUser(client: String, value: Float, date: String) {
        val ride = Ride(client, date, value)
        val user = FirebaseAuth.getInstance().currentUser


        database = FirebaseDatabase.getInstance().getReference("")

        val pushKey = database.push().key
        database.child(pushKey!!).setValue(ride)

    }
}
