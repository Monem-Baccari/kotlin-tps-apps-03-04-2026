package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int
)

data class Recommendation(
    val id: Int,
    val categoryId: Int,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val addressRes: Int
)
