package com.fakhri.buku_pedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AccountFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var profileImage: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var editButton: Button
    private lateinit var logoutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        auth = FirebaseAuth.getInstance()
        profileImage = view.findViewById(R.id.profile_image)
        nameTextView = view.findViewById(R.id.name_text_view)
        emailTextView = view.findViewById(R.id.email_text_view)
        editButton = view.findViewById(R.id.edit_button)
        logoutButton = view.findViewById(R.id.logout_button)

        loadUserData()

        editButton.setOnClickListener {
            Toast.makeText(requireContext(), "Edit feature not implemented", Toast.LENGTH_SHORT).show()
        }

        logoutButton.setOnClickListener {
            auth.signOut()
            Toast.makeText(requireContext(), "Logged out successfully", Toast.LENGTH_SHORT).show()
            // Navigate back to Login screen (depends on your navigation setup)
        }

        return view
    }

    private fun loadUserData() {
        val user: FirebaseUser? = auth.currentUser
        user?.let {
            nameTextView.text = it.displayName ?: "No Name"
            emailTextView.text = it.email
        }
    }
}