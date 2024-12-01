package com.fakhri.buku_pedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AccountFragment : Fragment() {

    private lateinit var textViewUserName: TextView
    private lateinit var textViewUserEmail: TextView
    private lateinit var textViewPassword: TextView
    private lateinit var textViewAddress: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // Initialize views
        textViewUserName = view.findViewById(R.id.textViewUserName)
        textViewUserEmail = view.findViewById(R.id.textViewUserEmail)
        textViewPassword = view.findViewById(R.id.textViewPassword)
        textViewAddress = view.findViewById(R.id.textViewAddress)

        // Set up UI elements here

        return view
    }
}