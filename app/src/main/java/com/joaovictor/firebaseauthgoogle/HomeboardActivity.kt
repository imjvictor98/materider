package com.joaovictor.firebaseauthgoogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_homeboard.*

class HomeboardActivity : AppCompatActivity() {

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

    private fun logout() {
        val user = FirebaseAuth.getInstance().currentUser

        if (user != null) {
            firebaseAuth.signOut()
            startActivity(Intent(this@HomeboardActivity, SignActivity::class.java))
            finish()
        }


    }

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

        firebaseAuth = FirebaseAuth.getInstance()

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
