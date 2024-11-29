package com.fakhri.buku_pedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val etEmail = findViewById<EditText>(R.id.email_edittext)
        val etPassword = findViewById<EditText>(R.id.password_edittext)
        val btnSignUp = findViewById<Button>(R.id.register_button)
        val btnGoToLogin = findViewById<TextView>(R.id.sign_in_textview)

        btnSignUp.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign up success
                        Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
                        // Navigate to login activity
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else {
                        // If sign up fails, display a message to the user.
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        btnGoToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}