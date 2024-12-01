package com.fakhri.buku_pedia

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhri.buku_pedia.api.RetrofitClient
import com.fakhri.buku_pedia.adapter.BooksAdapter
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.getBestSellingBooks().execute()
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    if (apiResponse != null) {
                        bestSellingBooksAdapter.submitList(apiResponse.data)
                    } else {
                        Toast.makeText(context, "Response body is null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    Toast.makeText(context, "Failed to load data: $errorBody", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }