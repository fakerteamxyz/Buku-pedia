package com.fakhri.buku_pedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView
import android.widget.TextView

class HomeFragment : Fragment() {

    private lateinit var searchView: SearchView
    private lateinit var textViewHeaderTitle: TextView
    private lateinit var textViewHeaderSubtitle: TextView
    private lateinit var rvBestDeals: RecyclerView
    private lateinit var textViewTopBooks: TextView
    private lateinit var rvTopBooks: RecyclerView
    private lateinit var textViewLatestBooks: TextView
    private lateinit var rvLatestBooks: RecyclerView
    private lateinit var textViewUpcomingBooks: TextView
    private lateinit var rvUpcomingBooks: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize views
        searchView = view.findViewById(R.id.searchView)
        textViewHeaderTitle = view.findViewById(R.id.textViewHeaderTitle)
        textViewHeaderSubtitle = view.findViewById(R.id.textViewHeaderSubtitle)
        rvBestDeals = view.findViewById(R.id.rv_best_deals)
        textViewTopBooks = view.findViewById(R.id.textViewTopBooks)
        rvTopBooks = view.findViewById(R.id.rv_top_books)
        textViewLatestBooks = view.findViewById(R.id.textViewLatestBooks)
        rvLatestBooks = view.findViewById(R.id.rv_latest_books)
        textViewUpcomingBooks = view.findViewById(R.id.textViewUpcomingBooks)
        rvUpcomingBooks = view.findViewById(R.id.rv_upcoming_books)

        // Set up RecyclerViews, SearchView, and other UI elements here

        return view
    }
}