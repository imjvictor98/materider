package com.joaovictor.firebaseauthgoogle.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joaovictor.firebaseauthgoogle.R
import kotlinx.android.synthetic.main.fragment_home.*

class ThirdFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvCommon.text = "Blog Fragment"
        commonLayout.setBackgroundColor(resources.getColor(android.R.color.holo_orange_dark))

    }
}