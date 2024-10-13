/**
 * Adapter class for displaying a list of products in a shopping cart using a RecyclerView.
 *
 * @property productList The list of products to be displayed.
 * @property onRemove A callback function to handle the removal of a product from the cart.
 */
package com.example.marketeasy

import Product
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartProductAdapter(
    private val productList: List<Product>,
    private val onRemove: (Product) -> Unit
) : RecyclerView.Adapter<CartProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {



    }

    override fun getItemCount() = productList.size

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName: TextView = itemView.findViewById(R.id.productName)
        private val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        private val productQuantity: TextView = itemView.findViewById(R.id.productQuantity)

        fun bind(product: Product) {
            productName.text = product.name
            productPrice.text = "$${product.price}"
            productQuantity.text = "Quantity: ${product.quantity}"
        }
    }
}
