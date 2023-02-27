package com.example.lr1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.edit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val shared_ref = getSharedPreferences("users", Context.MODE_PRIVATE)

        val pb = findViewById<ProgressBar>(R.id.progress)
        pb.setOnClickListener() {
            if (shared_ref.getString("login","").isNullOrEmpty()){
                pb.progress = 100
                val intent = Intent(this, RegistrationActivity::class.java)
                startActivity(intent)
            }
            else if(!shared_ref.getBoolean("autoLogIn", false)){
                pb.progress = 100
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            else{
                pb.progress = 100
                val intent = Intent(this, ContentActivity::class.java)
                startActivity(intent)
            }


        }
    }
}