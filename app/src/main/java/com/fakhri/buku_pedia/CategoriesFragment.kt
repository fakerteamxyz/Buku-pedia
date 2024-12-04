package com.fakhri.buku_pedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhri.buku_pedia.adapter.CategoryAdapter
import com.fakhri.buku_pedia.models.Category

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.categories_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        val categories = listOf(
            Category("Non-fiction", R.drawable.non_fiction),
            Category("Classics", R.drawable.classics),
            Category("Fantasy", R.drawable.fantasy),
            Category("Young Adult", R.drawable.young_adult),
            Category("Crime", R.drawable.crime),
            Category("Horror", R.drawable.horror),
            Category("Sci-Fi", R.drawable.sci_fi),
            Category("Drama", R.drawable.drama)
        )

        val adapter = CategoryAdapter(categories)
        recyclerView.adapter = adapter

        return view
    }
}