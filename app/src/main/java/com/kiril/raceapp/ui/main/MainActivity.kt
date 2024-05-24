package com.kiril.raceapp.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kiril.raceapp.R
import com.kiril.raceapp.ui.auth.AuthActivity
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var supabaseClient: SupabaseClient

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = runBlocking {
            try {
                supabaseClient.auth.retrieveUserForCurrentSession(updateSession = true)
            } catch (e: Exception) {
                null
            }
        }

        if (user == null) {
            startActivity(Intent(this, AuthActivity::class.java))
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.nav_race -> {
                    loadFragment(RaceFragment())
                    true
                }

                else -> false
            }
        }

        // Load the default fragment
        bottomNavigationView.selectedItemId = R.id.nav_home
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

