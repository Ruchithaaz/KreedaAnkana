package com.example.kreedaankana

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScoresActivity : AppCompatActivity() {

    private lateinit var teamOneScore: EditText
    private lateinit var teamTwoScore: EditText
    private lateinit var saveScoreButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        teamOneScore = findViewById(R.id.teamOneScore)
        teamTwoScore = findViewById(R.id.teamTwoScore)
        saveScoreButton = findViewById(R.id.saveScoreButton)

        saveScoreButton.setOnClickListener {
            Toast.makeText(this, "Score Saved", Toast.LENGTH_LONG).show()
        }
    }
}