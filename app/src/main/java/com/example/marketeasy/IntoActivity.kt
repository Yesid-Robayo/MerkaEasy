/**
 * IntoActivity is the entry point of the application which extends AppCompatActivity.
 * This activity sets up the UI and handles the transition to the LoginActivity.
 *
 * Key functionalities:
 * - Disables night mode.
 * - Enables edge-to-edge display.
 * - Sets the content view to activity_into layout.
 * - Adjusts padding to accommodate system bars.
 * - Displays a welcome message with a specific part of the text highlighted in a custom color.
 * - Navigates to LoginActivity when the login button is clicked.
 *
 * @see AppCompatActivity
 * @see AppCompatDelegate
 * @see ContextCompat
 * @see WindowInsetsCompat
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
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IntoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContentView(R.layout.activity_into)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val textView = findViewById<TextView>(R.id.textView)
        val fullText = "Bienvenido a MerkaEasy!!"
        val spannable = SpannableString(fullText)
        val color = ContextCompat.getColor(this, R.color.greenMain)
        val loginButton: Button = findViewById(R.id.button)

        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        spannable.setSpan(

            ForegroundColorSpan(color),
            fullText.indexOf("MerkaEasy"),
            fullText.indexOf("MerkaEasy") + "MerkaEasy".length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textView.text = spannable

    }
}