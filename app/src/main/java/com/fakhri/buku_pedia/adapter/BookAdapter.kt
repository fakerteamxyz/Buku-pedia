package com.fakhri.buku_pedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fakhri.buku_pedia.R
import com.fakhri.buku_pedia.book.Book

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    private var books: List<Book> = listOf()

    fun submitList(bookList: List<Book>) {
        books = bookList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookCover: ImageView = itemView.findViewById(R.id.book_cover)
        private val bookTitle: TextView = itemView.findViewById(R.id.book_title)
        private val bookAuthor: TextView = itemView.findViewById(R.id.book_author)
        private val bookPrice: TextView = itemView.findViewById(R.id.book_price)

        fun bind(book: Book) {
            bookTitle.text = book.title
            bookAuthor.text = book.author
            bookPrice.text = "Rp ${book.finalPrice}"
            Glide.with(itemView.context).load(book.image).into(bookCover)
        }
    }
}