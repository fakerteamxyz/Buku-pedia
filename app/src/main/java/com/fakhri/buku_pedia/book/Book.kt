package com.fakhri.buku_pedia.book

data class Book(
    val product_meta_id: Int,
    val title: String,
    val image: String,
    val slug: String,
    val author: String,
    val final_price: Int,
    val slice_price: Int,
    val discount: Int,
    val is_oos: Boolean,
    val sku: String,
    val category_slugs: String,
    val format: String,
    val applied_promo_slug: String,
    val store_name: String?,
    val isbn: String
)
