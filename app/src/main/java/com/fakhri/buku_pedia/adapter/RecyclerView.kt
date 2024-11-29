package com.fakhri.buku_pedia.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhri.buku_pedia.R

class BooksByCategoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var booksAdapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_by_category)

        recyclerView = findViewById(R.id.rv_books)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val books = fetchBooksByCategory("Agama")
        booksAdapter = BooksAdapter(books)
        recyclerView.adapter = booksAdapter
    }

    private fun fetchBooksByCategory(category: String): List<Book> {
        return listOf(
            Book(
                "Hidup Ini singkat",
                "Dale Carnegie",
                "Rp 50.000",
                "Genre 1",
                R.drawable.examplebook1
            ),
            Book(
                "Sukses Memimpin",
                "Dale Carnegie",
                "Rp 60.000",
                "Genre 2",
                R.drawable.examplebook2
            )
        )
    }
}