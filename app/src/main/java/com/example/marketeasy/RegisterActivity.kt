/**
 * RegisterActivity is an AppCompatActivity that handles the registration screen of the MarketEasy app.
 * 
 * This activity performs the following tasks:
 * - Enables edge-to-edge display.
 * - Sets the content view to the activity_register layout.
 * - Customizes the text color of a portion of a TextView.
 * - Adjusts the padding of the main view to account for system window insets.
 * - Sets up click listeners for navigation to the LoginActivity.
 * 
 * Methods:
 * - onCreate(savedInstanceState: Bundle?): Initializes the activity, sets up the UI components, and defines click listeners.
 * 
 * UI Components:
 * - TextView (R.id.textView3): Displays the app name with customized text color.
 * - TextView (R.id.loginText): Navigates to the LoginActivity when clicked.
 * - Button (R.id.registeButton): Navigates to the LoginActivity when clicked.
 */
package com.example.marketeasy

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val textView = findViewById<TextView>(R.id.textView3)
        val fullText = "MerkaEasy"
        val spannable = SpannableString(fullText)
        val color = ContextCompat.getColor(this, R.color.greenMain)

        val startIndex = fullText.indexOf("Easy")
        val endIndex = startIndex + "Easy".length

        spannable.setSpan(ForegroundColorSpan(color), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannable

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val textViewRegister: TextView = findViewById(R.id.loginText)
        textViewRegister.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)        }


        val loginButton: Button = findViewById(R.id.registeButton)

        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}