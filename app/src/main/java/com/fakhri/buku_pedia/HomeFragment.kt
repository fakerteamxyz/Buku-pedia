package com.fakhri.buku_pedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhri.buku_pedia.adapter.BookAdapter
import com.fakhri.buku_pedia.book.Book
import com.google.firebase.database.FirebaseDatabase

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private val database = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.rv_best_selling_book)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        fetchBooks()

        return view
    }

    private fun fetchBooks() {
        database.child("data").get().addOnSuccessListener { snapshot ->
            val books = snapshot.children.mapNotNull { it.getValue(Book::class.java) }
            bookAdapter = BookAdapter(books)
            recyclerView.adapter = bookAdapter
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Failed to load books", Toast.LENGTH_SHORT).show()
        }
    }
}