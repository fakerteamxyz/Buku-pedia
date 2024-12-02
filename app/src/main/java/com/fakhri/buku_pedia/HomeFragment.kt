package com.fakhri.buku_pedia

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhri.buku_pedia.adapter.BooksAdapter
import com.fakhri.buku_pedia.book.Book
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var bestSellingBooksRecyclerView: RecyclerView
    private lateinit var bestSellingBooksAdapter: BooksAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bestSellingBooksRecyclerView = view.findViewById(R.id.rv_best_deals)
        bestSellingBooksRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bestSellingBooksAdapter = BooksAdapter()
        bestSellingBooksRecyclerView.adapter = bestSellingBooksAdapter

        fetchBestSellingBooks()
    }

    private fun fetchBestSellingBooks() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("books")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val bookList = mutableListOf<Book>()
                for (snapshot in dataSnapshot.children) {
                    val book = snapshot.getValue(Book::class.java)
                    if (book != null) {
                        bookList.add(book)
                    }
                }
                bestSellingBooksAdapter.submitList(bookList)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed to load data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}