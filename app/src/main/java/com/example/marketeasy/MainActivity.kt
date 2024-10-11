package com.example.marketeasy

import ProductAdapter
import android.os.Bundle
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
            Product("Product 1", R.drawable.icono),
            Product("Product 2", R.drawable.icono),
            Product("Product 3", R.drawable.icono),
            Product("Product 4", R.drawable.icono),
            Product("Product 5", R.drawable.icono),
        Product("Product 6", R.drawable.icono),
            Product("Product 4", R.drawable.icono),
            Product("Product 5", R.drawable.icono),
            Product("Product 4", R.drawable.icono),
            Product("Product 5", R.drawable.icono),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = ProductAdapter(productList)

    }
}