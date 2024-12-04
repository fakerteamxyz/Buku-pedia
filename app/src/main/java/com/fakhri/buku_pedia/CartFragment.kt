package com.fakhri.buku_pedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.Button
import com.fakhri.buku_pedia.adapter.CartItemAdapter

class CartFragment : Fragment() {
    private lateinit var cartItemsRecyclerView: RecyclerView
    private lateinit var subtotalTextView: TextView
    private lateinit var shippingTextView: TextView
    private lateinit var totalTextView: TextView
    private lateinit var proceedToCheckoutButton: Button

    private val cartItems = mutableListOf<CartItem>()
    private var subtotal = 0

    companion object {
        private const val shippingCost = 1000 // Example shipping cost
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        initViews(view)
        loadCartItems()
        updateOrderSummary()
        return view
    }

    private fun initViews(view: View) {
        cartItemsRecyclerView = view.findViewById<RecyclerView>(R.id.cart_items_recycler_view)
        subtotalTextView = view.findViewById<TextView>(R.id.subtotal_text_view)
        shippingTextView = view.findViewById<TextView>(R.id.shipping_text_view)
        totalTextView = view.findViewById<TextView>(R.id.total_text_view)
        proceedToCheckoutButton = view.findViewById<Button>(R.id.proceed_to_checkout_button)
    }

    private fun loadCartItems() {
        // Load cart items from data source (e.g., database, API)
        cartItems.addAll(fetchCartItems())
        val cartAdapter = CartItemAdapter(cartItems)
        cartItemsRecyclerView.adapter = cartAdapter
    }

    private fun updateOrderSummary() {
        subtotal = cartItems.sumOf { it.price * it.quantity }
        subtotalTextView.setText(formatPrice(subtotal))
        shippingTextView.setText(formatPrice(shippingCost))
        totalTextView.setText(formatPrice(subtotal + shippingCost))
    }

    private fun formatPrice(price: Int): String {
        return "Rp$price"
    }

    private fun fetchCartItems(): List<CartItem> {
        // Fetch cart items from data source and return them
        return listOf(
            CartItem("Kamus Inggris Indonesia", 140000, 1),
            CartItem("Filosofi Teras (New Cover)", 97200, 1)
        )
    }

    data class CartItem(
        val name: String,
        val price: Int,
        var quantity: Int
    )
}