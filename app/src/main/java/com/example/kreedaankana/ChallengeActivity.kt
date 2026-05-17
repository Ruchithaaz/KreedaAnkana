package com.example.kreedaankana

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class ChallengeActivity : AppCompatActivity() {

    private lateinit var teamNameEditText: EditText
    private lateinit var sportEditText: EditText
    private lateinit var challengeDateEditText: EditText
    private lateinit var postChallengeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_challenge)

        teamNameEditText = findViewById(R.id.teamNameEditText)
        sportEditText = findViewById(R.id.sportEditText)
        challengeDateEditText = findViewById(R.id.challengeDateEditText)
        postChallengeButton = findViewById(R.id.postChallengeButton)

        postChallengeButton.setOnClickListener {
            val teamName = teamNameEditText.text.toString().trim()
            val sport = sportEditText.text.toString().trim()
            val date = challengeDateEditText.text.toString().trim()

            if (teamName.isEmpty() || sport.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Fill all details", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Challenge Posted", Toast.LENGTH_LONG).show()
            }
        }
    }
}