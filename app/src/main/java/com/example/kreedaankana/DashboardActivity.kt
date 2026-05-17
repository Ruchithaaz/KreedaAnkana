package com.example.kreedaankana
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var bookSlotButton: Button
    private lateinit var challengeButton: Button
    private lateinit var matchesButton: Button
    private lateinit var scoresButton: Button
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dasboard)

        bookSlotButton = findViewById(R.id.bookSlotButton)
        challengeButton = findViewById(R.id.challengeButton)
        matchesButton = findViewById(R.id.matchesButton)
        scoresButton = findViewById(R.id.scoresButton)
        logoutButton = findViewById(R.id.logoutButton)
        bookSlotButton.setOnClickListener {
            startActivity(Intent(this, BookingActivity::class.java))
        }

        challengeButton.setOnClickListener {
            startActivity(Intent(this, ChallengeActivity::class.java))
        }

        matchesButton.setOnClickListener {
            startActivity(Intent(this, MatchesActivity::class.java))
        }

        scoresButton.setOnClickListener {
            startActivity(Intent(this, ScoresActivity::class.java))
            logoutButton.setOnClickListener {

                FirebaseAuth.getInstance().signOut()

                startActivity(Intent(this, MainActivity::class.java))

                finish()
            }
        }
    }
}