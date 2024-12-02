package com.fakhri.buku_pedia.book

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Book(
    val productMetaId: Int = 0,
    val title: String = "",
    val image: String = "",
    val slug: String = "",
    val author: String = "",
    val finalPrice: Int = 0,
    val slicePrice: Int = 0,
    val discount: Int = 0,
    val isOos: Boolean = false,
    val sku: String = "",
    val categorySlugs: String = "",
    val format: String = "",
    val appliedPromoSlug: String = "",
    val storeName: String = "",
    val isbn: String = ""
)