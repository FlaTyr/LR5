package com.example.lr1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    fun gettingReference(){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val logIn = findViewById<Button>(R.id.button)
        val login = findViewById<EditText>(R.id.etext)
        val pass = findViewById<EditText>(R.id.etext2)
        val autoE = findViewById<CheckBox>(R.id.checkbox)
        logIn.setOnClickListener(){
            val shared_ref = getSharedPreferences("users", Context.MODE_PRIVATE)
            shared_ref.edit().putBoolean("autoLogIn", autoE.isChecked).apply()
            var error = ""
            if (shared_ref.getString("login", "") != login.text.toString())
                error += "логин не существует\n"
            if (shared_ref.getString("password", "") != pass.text.toString())
                error += "пароль не подходит\n"
            if (!error.isNullOrEmpty())
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            else{
                val intent = Intent(this, ContentActivity::class.java)
                startActivity(intent)
            }
        }
    }
}