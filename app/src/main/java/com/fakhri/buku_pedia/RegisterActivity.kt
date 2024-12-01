package com.fakhri.buku_pedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnBack = findViewById<ImageButton>(R.id.btn_back)

        btnBack.setOnClickListener {
            startActivity(Intent(this, OnboardingActivity::class.java))
            finish()
        }

        auth = FirebaseAuth.getInstance()

        val etEmail = findViewById<EditText>(R.id.email_edittext)
        val etPassword = findViewById<EditText>(R.id.password_edittext)
        val btnRegister = findViewById<Button>(R.id.register_button)

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Registration success
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        // Navigate to login activity
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else {
                        // If registration fails, display a message to the user.
                        Toast.makeText(this, "Registration failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}