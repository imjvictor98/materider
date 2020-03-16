package com.joaovictor.firebaseauthgoogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_homeboard.*

class HomeboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeboard)

        if (savedInstanceState == null) {
            val fragment = RegisterFragment()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                .commit()
        }

        setSupportActionBar(toolbar)

        bottomNavigationView.setOnNavigationItemSelectedListener {menuItem ->
            when(menuItem.itemId) {
                R.id.nav_1 -> {
                    val fragment = RegisterFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_2 -> {
                    val fragment = SecondFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_3 -> {
                    val fragment = ThirdFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }


    }


}
