package com.fakhri.buku_pedia.models

import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    @DrawableRes val imageResId: Int
)