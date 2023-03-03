package com.example.lr1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContentActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        navController = this.findNavController(R.id.nav_host_frag)


        val bottom_nav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottom_nav.setupWithNavController(navController)
    }
}