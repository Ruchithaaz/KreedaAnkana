package com.example.kreedaankana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    private lateinit var loginButton: Button
    private lateinit var openRegisterButton: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.emailEditText)

        passwordEditText = findViewById(R.id.passwordEditText)

        loginButton = findViewById(R.id.loginButton)

        openRegisterButton =
            findViewById(R.id.openRegisterButton)

        loginButton.setOnClickListener {

            val email =
                emailEditText.text.toString()

            val password =
                passwordEditText.text.toString()

            if(email.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter Email and Password",
                    Toast.LENGTH_LONG
                ).show()

            }
            else {

                auth.signInWithEmailAndPassword(
                    email,
                    password
                ).addOnCompleteListener {

                    if(it.isSuccessful) {

                        Toast.makeText(
                            this,
                            "Login Successful",
                            Toast.LENGTH_LONG
                        ).show()

                        val intent =
                            Intent(
                                this,
                                DashboardActivity::class.java
                            )

                        startActivity(intent)

                        finish()

                    }
                    else {

                        Toast.makeText(
                            this,
                            "Login Failed",
                            Toast.LENGTH_LONG
                        ).show()

                    }

                }

            }

        }

        openRegisterButton.setOnClickListener {

            val intent =
                Intent(
                    this,
                    RegisterActivity::class.java
                )

            startActivity(intent)

        }

    }
}