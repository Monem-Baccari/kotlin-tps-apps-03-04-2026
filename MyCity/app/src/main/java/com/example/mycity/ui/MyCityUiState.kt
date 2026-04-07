package com.example.mycity.ui

import com.example.mycity.model.Category
import com.example.mycity.model.Recommendation

data class MyCityUiState(
    val categories: List<Category> = emptyList(),
    val recommendations: List<Recommendation> = emptyList(),
    val currentCategory: Category? = null,
    val currentRecommendation: Recommendation? = null,
    val isShowingListPage: Boolean = true
)
