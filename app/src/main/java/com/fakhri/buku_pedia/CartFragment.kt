package com.fakhri.buku_pedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CartFragment : Fragment() {

    private lateinit var rvCartItems: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        // Initialize RecyclerView
        rvCartItems = view.findViewById(R.id.rv_cart_items)

        // Set up RecyclerView, adapters, and other UI elements here

        return view
    }
}