/**
 * CartActivity is an activity that displays a list of products added to the cart.
 * It uses a RecyclerView to show the list of products and allows users to remove items from the cart.
 *
 * @property cartProductList A mutable list of Product objects representing the products in the cart.
 *
 * Methods:
 * - onCreate(savedInstanceState: Bundle?): Initializes the activity, sets up the RecyclerView, 
 *   adds sample products to the cart, and handles the back button functionality.
 *
 * Usage:
 * - This activity is intended to be used as part of an Android application to manage and display 
 *   the user's shopping cart.
 */
package com.example.marketeasy

import Product
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView

class CartActivity : AppCompatActivity() {
    private val cartProductList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Add sample products to the cart
        cartProductList.add(Product("Product 1", R.drawable.icono, price = 10.99, quantity = 1))
        cartProductList.add(Product("Product 2", R.drawable.icono, price = 15.49, quantity = 2))
        cartProductList.add(Product("Product 3", R.drawable.icono, price = 7.99, quantity = 3))

        val recyclerViewCart = findViewById<RecyclerView>(R.id.recyclerViewCart)
        recyclerViewCart.layoutManager = LinearLayoutManager(this)

        // Create the adapter and set it to the RecyclerView
        val adapter = CartProductAdapter(cartProductList) { productToRemove ->
            cartProductList.remove(productToRemove) // Remove the product from the list
        }

        recyclerViewCart.adapter = adapter // Set the adapter to the RecyclerView

        // Back button
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Use the onBackPressedDispatcher for back navigation
        }
    }
}
