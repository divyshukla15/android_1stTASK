package com.example.tasksubmit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var emailEdt: EditText
    lateinit var passwordEdt: EditText
    lateinit var loginbtn: Button
    lateinit var forgot_password : Button
    lateinit var google_signup : ImageButton
    lateinit var facebook_signup  : ImageButton
    lateinit var apple_signup : ImageButton
    lateinit var sign_up : Button
    val PASSWORD_PATTERN = Pattern.compile(".{4,}")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEdt = findViewById(R.id.email)
        passwordEdt = findViewById(R.id.password)
        loginbtn = findViewById(R.id.login)
        forgot_password = findViewById(R.id.forgot_pass)
        google_signup = findViewById(R.id.google)
        facebook_signup = findViewById(R.id.facebook)
        apple_signup = findViewById(R.id.apple)
        sign_up = findViewById(R.id.sign_up)

        forgot_password.setOnClickListener {
            Toast.makeText(this, " forgot_password", Toast.LENGTH_SHORT).show()
        }
        google_signup.setOnClickListener {
            Toast.makeText(this, "google_signup ", Toast.LENGTH_SHORT).show()
        }
        facebook_signup.setOnClickListener {
            Toast.makeText(this, "facebook_signup ", Toast.LENGTH_SHORT).show()
        }
        apple_signup.setOnClickListener {
            Toast.makeText(this, "  apple_signup", Toast.LENGTH_SHORT).show()
        }
        sign_up.setOnClickListener {
            Toast.makeText(this, " sign_up ", Toast.LENGTH_SHORT).show()
        }
        loginbtn.setOnClickListener {
            if (!validateEmail() || !validatePassword()) {
                return@setOnClickListener
            } else {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
            }
        }

    }
    private fun validateEmail(): Boolean {

        val inputEmail: String = emailEdt.text.toString().trim()
        if (inputEmail.isEmpty()) {
            emailEdt.error = "Email can't be empty"

            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()) {
            emailEdt.error = "Please enter a valid email address"
            return false
        } else {

            emailEdt.error = null
            return true
        }

    }
    private fun validatePassword(): Boolean {

        val inputPassword: String = passwordEdt.text.toString().trim()
        if (inputPassword.isEmpty()) {
            passwordEdt.error = "Password can't be empty"
            return false

        } else if (!PASSWORD_PATTERN.matcher(inputPassword).matches()) {
            passwordEdt.error = "Please enter a valid password"
            return false
        } else {

            passwordEdt.error = null
            return true
        }

    }

}