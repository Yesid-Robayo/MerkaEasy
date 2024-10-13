/**
 * Adapter class for displaying a list of products in a RecyclerView.
 *
 * @property productList The list of products to display.
 */
class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * ViewHolder class for holding the views for each product item.
     *
     * @property productImage The ImageView for displaying the product image.
     * @property productName The TextView for displaying the product name.
     * @property productPrice The TextView for displaying the product price.
     * @property quantityText The TextView for displaying the product quantity.
     * @property buttonIconMenos The ImageView for the decrement button.
     * @property buttonIconPlus The ImageView for the increment button.
     */
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        val quantityText: TextView = itemView.findViewById(R.id.quantityText)
        val buttonIconMenos: ImageView = itemView.findViewById(R.id.buttonIconMenos)
        val buttonIconPlus: ImageView = itemView.findViewById(R.id.buttonIconPlus)
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ProductViewHolder that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        // Set product details
        holder.productName.text = product.name
        holder.productImage.setImageResource(product.imageResId)
        holder.productPrice.text = "Price: $${product.price}"
        holder.quantityText.text = product.quantity.toString()

        // Handle increment and decrement buttons
        holder.buttonIconPlus.setOnClickListener {
            product.quantity += 1
            holder.quantityText.text = product.quantity.toString()
        }

        holder.buttonIconMenos.setOnClickListener {
            if (product.quantity > 1) {
                product.quantity -= 1
                holder.quantityText.text = product.quantity.toString()
            }
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount() = productList.size
}
