package com.joaovictor.firebaseauthgoogle.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.joaovictor.firebaseauthgoogle.*
import com.joaovictor.firebaseauthgoogle.fragment.RegisterFragment
import com.joaovictor.firebaseauthgoogle.fragment.ListRideFragment
import com.joaovictor.firebaseauthgoogle.fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_homeboard.*

class HomeActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.logout -> {
                logout()
               true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeboard)

        if (savedInstanceState == null) {
            val fragment =
                RegisterFragment()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                .commit()
        }

        firebaseAuth = FirebaseAuth.getInstance()

        setSupportActionBar(toolbar)

        bottomNavigationView.setOnNavigationItemSelectedListener {menuItem ->
            when(menuItem.itemId) {
                R.id.nav_1 -> {
                    val fragment =
                        RegisterFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_2 -> {
                    val fragment =
                        ListRideFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_3 -> {
                    val fragment =
                        ThirdFragment()

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

    private fun logout() {
        val user = FirebaseAuth.getInstance().currentUser

        if (user != null) {
            firebaseAuth.signOut()
            val signOutIntent = Intent(this@HomeActivity, SignActivity::class.java)
            signOutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(signOutIntent)
            finish()
        }


    }


}
