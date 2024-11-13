package com.meanzunlimitedinc.cafeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Retrieve the order message passed from MainActivity
        val orderMessage = intent.getStringExtra("orderMessage") ?: "No order message"

        // Display the message in an EditText
        val order_textview: TextView = findViewById(R.id.order_textview)
        order_textview.setText(orderMessage)
        val submitorder : Button = findViewById(R.id.submitorder)

        val sameday: RadioButton = findViewById(R.id.sameday)
        val nextday: RadioButton = findViewById(R.id.nextday)
        val pickup: RadioButton = findViewById(R.id.pickup)

        val radioClickListener = View.OnClickListener { view ->
            onRadioButtonClicked(view)
        }
        sameday.setOnClickListener(radioClickListener)
        nextday.setOnClickListener(radioClickListener)
        pickup.setOnClickListener(radioClickListener)

        submitorder.setOnClickListener {
            val intent = Intent(this,OrderDetailsActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    // Method to handle RadioButton clicks
    fun onRadioButtonClicked(view: View) {
        // Ensure that only RadioButtons trigger this code
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.sameday -> if (checked) {
                    Toast.makeText(this, "Same Day Selected", Toast.LENGTH_SHORT).show()
                }
                R.id.nextday -> if (checked) {
                    Toast.makeText(this, "Next Day Selected", Toast.LENGTH_SHORT).show()
                }
                R.id.pickup -> if (checked) {
                    Toast.makeText(this, "Pick Up Selected", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}