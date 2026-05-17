package com.example.kreedaankana

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class BookingActivity : AppCompatActivity() {

    private lateinit var groundNameEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var timeEditText: EditText
    private lateinit var bookButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        groundNameEditText = findViewById(R.id.groundNameEditText)
        dateEditText = findViewById(R.id.dateEditText)
        timeEditText = findViewById(R.id.timeEditText)
        bookButton = findViewById(R.id.bookButton)

        bookButton.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()

            val ground = groundNameEditText.text.toString().trim()
            val date = dateEditText.text.toString().trim()
            val time = timeEditText.text.toString().trim()

            if (ground.isEmpty() || date.isEmpty() || time.isEmpty()) {
                Toast.makeText(this, "Fill all details", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val database = FirebaseDatabase.getInstance().getReference("Bookings")
            val bookingId = database.push().key

            if (bookingId == null) {
                Toast.makeText(this, "Booking ID error", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val booking = HashMap<String, String>()
            booking["bookingId"] = bookingId
            booking["ground"] = ground
            booking["date"] = date
            booking["time"] = time

            database.child(bookingId).setValue(booking)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {



                    } else {
                        Toast.makeText(
                            this,
                            "Booking Failed: ${task.exception?.message}",
                            Toast.LENGTH_LONG
                        ).show()



                    }

                }
        }
    }
}