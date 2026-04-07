package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.model.Category
import com.example.mycity.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        MyCityUiState(
            categories = LocalDataProvider.categories,
            recommendations = LocalDataProvider.recommendations.filter { it.categoryId == LocalDataProvider.categories.first().id },
            currentCategory = LocalDataProvider.categories.first(),
            currentRecommendation = null,
            isShowingListPage = true
        )
    )
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun updateCurrentCategory(category: Category) {
        _uiState.update {
            it.copy(
                currentCategory = category,
                recommendations = LocalDataProvider.recommendations.filter { rec -> rec.categoryId == category.id },
                isShowingListPage = true
            )
        }
    }

    fun updateCurrentRecommendation(recommendation: Recommendation) {
        _uiState.update {
            it.copy(
                currentRecommendation = recommendation,
                isShowingListPage = false
            )
        }
    }

    fun navigateBackToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }
}
