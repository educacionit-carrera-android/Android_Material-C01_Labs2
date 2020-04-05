package com.example.materialdesign_bottomnavview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, createHomeFragment())
            .commit()

        setupBottomNavView()
    }

    private fun setupBottomNavView() {
        bottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val transaction = supportFragmentManager
                .beginTransaction()

            val fragment = when (it.itemId) {
                R.id.menuHome -> createHomeFragment()
                R.id.menuFavoritos -> createFavoriteFragment()
                R.id.menuMapa -> createMapFragment()
                else -> createHomeFragment()
            }

            transaction
                .replace(R.id.container, fragment)
                .commit()
            true
        }
    }

    private fun createHomeFragment() = HomeFragment()
    private fun createFavoriteFragment() = FavoriteFragment()
    private fun createMapFragment() = MapFragment()
}
