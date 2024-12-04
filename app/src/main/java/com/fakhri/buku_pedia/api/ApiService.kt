package com.fakhri.buku_pedia.api

import retrofit2.Call
import retrofit2.http.GET
import com.fakhri.buku_pedia.book.Book

data class ApiResponse(
    val code: String,
    val message: String,
    val data: List<Book>
)

interface ApiService {
    @GET("public/featured-category?is_available_only=true&page=1&size=20&type=best-selling-book")
    fun getBestSellingBooks(): Call<ApiResponse>
}