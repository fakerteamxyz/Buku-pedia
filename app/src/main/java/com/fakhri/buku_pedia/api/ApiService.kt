package com.fakhri.buku_pedia.api

import com.fakhri.buku_pedia.book.Book
import retrofit2.Call
import retrofit2.http.GET

data class ApiResponse(
    val code: String,
    val message: String,
    val data: List<Book>
)

interface ApiService {
    @GET("public/featured-category?is_available_only=true&page=1&size=20&type=best-selling-book")
    fun getBestSellingBooks(): Call<ApiResponse>
}