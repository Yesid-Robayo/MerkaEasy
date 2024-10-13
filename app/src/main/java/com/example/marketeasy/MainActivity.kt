/**
 * MainActivity is the entry point of the MarketEasy application.
 * It sets up the main user interface and initializes the product list and RecyclerView.
 *
 * Functions:
 * - onCreate(savedInstanceState: Bundle?): Initializes the activity, sets up edge-to-edge display,
 *   inflates the layout, configures window insets, and sets up the RecyclerView with a grid layout
 *   and a product adapter. Also sets up a click listener for the cart button.
 *
 * Variables:
 * - productList: A list of Product objects representing the available products in the market.
 * - recyclerView: The RecyclerView that displays the list of products in a grid layout.
 *
 * Layout:
 * - activity_main: The main layout resource file for this activity.
 * - recyclerView: The RecyclerView widget in the layout.
 * - buttonIcon: The ImageView widget that acts as a button to navigate to the CartActivity.
 */
package com.example.marketeasy

import Product
import ProductAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val productList = listOf(
            Product("Product 1", R.drawable.icono, quantity = 1, price = 10.99),
            Product("Product 2", R.drawable.icono, quantity = 1, price = 15.49),
            Product("Product 3", R.drawable.icono, quantity = 1, price = 7.99),
            Product("Product 4", R.drawable.icono, quantity = 1, price = 12.99),
            Product("Product 5", R.drawable.icono, quantity = 1, price = 9.50),
            Product("Product 6", R.drawable.icono, quantity = 1, price = 5.75),
            Product("Product 7", R.drawable.icono, quantity = 1, price = 14.99),
            Product("Product 8", R.drawable.icono, quantity = 1, price = 19.99),
            Product("Product 9", R.drawable.icono, quantity = 1, price = 11.49),
            Product("Product 10", R.drawable.icono, quantity = 1, price = 16.25)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Distribución en 2 columnas
        recyclerView.adapter = ProductAdapter(productList) // Set del adaptador con la lista de productos

        findViewById<ImageView>(R.id.buttonIcon).setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
             }
    }

}
