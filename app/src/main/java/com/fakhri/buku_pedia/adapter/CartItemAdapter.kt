package com.fakhri.buku_pedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fakhri.buku_pedia.R
import com.fakhri.buku_pedia.CartFragment.CartItem

class CartItemAdapter(
    private val cartItems: List<CartItem>
) : RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.bind(cartItem)
    }

    override fun getItemCount() = cartItems.size

    inner class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        private val priceTextView: TextView = itemView.findViewById(R.id.price_text_view)
        private val quantityTextView: TextView = itemView.findViewById(R.id.quantity_text_view)

        fun bind(cartItem: CartItem) {
            titleTextView.text = cartItem.name
            priceTextView.text = formatPrice(cartItem.price)
            quantityTextView.text = cartItem.quantity.toString()
        }

        private fun formatPrice(price: Int): String {
            return "Rp$price"
        }
    }
}