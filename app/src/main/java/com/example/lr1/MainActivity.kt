package com.example.lr1

import android.os.Bundle
import android.text.InputType.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
/*        setContentView(R.layout.activity_registration)*/
        val reg = findViewById<Button>(R.id.button)
        val login = findViewById<EditText>(R.id.etext)
        val pass = findViewById<EditText>(R.id.etext2)
        val pass_re = findViewById<EditText>(R.id.etext3)
        val on_mail = findViewById<TextView>(R.id.text3)
        val on_phone = findViewById<TextView>(R.id.text4)

        reg.setOnClickListener{
            var error = ""
            if ('@' !in login.text.toString() && on_mail.currentTextColor == resources.getColor(R.color.purple_200))
                error += "нет знака @\n"
            if ('+' !in login.text.toString()&& on_mail.currentTextColor == resources.getColor(R.color.black))
                error += "нет знака +\n"
            if (!pass.text.toString().equals(pass_re.text.toString()))
                error += "пароли не совпадают\n"
            if (pass.text.toString().length < 8)
                error += "пароль <8 символов\n"
            if (!error.isEmpty())
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()

        }
        on_mail.setOnClickListener {
            on_mail.setTextColor(resources.getColor(R.color.purple_200))
            on_phone.setTextColor(resources.getColor(R.color.black))
            login.text = null
            pass.text = null
            pass_re.text = null
            login.hint = "Введите email"
            login.inputType = TYPE_CLASS_TEXT
        }
        on_phone.setOnClickListener {
            on_phone.setTextColor(resources.getColor(R.color.purple_200))
            on_mail.setTextColor(resources.getColor(R.color.black))
            login.text = null
            pass.text = null
            pass_re.text = null
            login.hint = "Введите номер"
            login.inputType = TYPE_CLASS_PHONE
        }
    }
}