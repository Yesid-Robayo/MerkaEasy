package com.example.marketeasy

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
/**
 * LoginActivity is responsible for handling the login screen of the application.
 * It extends AppCompatActivity and overrides the onCreate method to set up the UI and event listeners.
 *
 * Key functionalities:
 * - Enables edge-to-edge display.
 * - Sets the content view to activity_login layout.
 * - Customizes a TextView to display "MerkaEasy" with "Easy" in a different color.
 * - Sets up a click listener on a TextView to navigate to the RegisterActivity.
 * - Adjusts padding to accommodate system bars using WindowInsetsCompat.
 * - Sets up a click listener on a Button to navigate to the MainActivity.
 *
 * @see AppCompatActivity
 * @see RegisterActivity
 * @see MainActivity
 */
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_login)

        val textView = findViewById<TextView>(R.id.textView3)
        val fullText = "MerkaEasy"
        val spannable = SpannableString(fullText)
        val color = ContextCompat.getColor(this, R.color.greenMain)

        val startIndex = fullText.indexOf("Easy")
        val endIndex = startIndex + "Easy".length

        spannable.setSpan(ForegroundColorSpan(color), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val textViewRegister: TextView = findViewById(R.id.textView9)
        textViewRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)        }
        textView.text = spannable

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val loginButton: Button = findViewById(R.id.button)

        loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
