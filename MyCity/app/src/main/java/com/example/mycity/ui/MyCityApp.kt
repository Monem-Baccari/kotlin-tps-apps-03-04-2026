package com.example.mycity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Museum
import androidx.compose.material.icons.filled.Park
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.Recommendation
import com.example.mycity.ui.utils.MyCityContentType

enum class MyCityScreen {
    Categories,
    Recommendations,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: MyCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val navController = rememberNavController()

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> MyCityContentType.ListOnly
        WindowWidthSizeClass.Medium -> MyCityContentType.ListOnly
        WindowWidthSizeClass.Expanded -> MyCityContentType.ListAndDetail
        else -> MyCityContentType.ListOnly
    }

    Scaffold(
        topBar = {
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentScreen = MyCityScreen.valueOf(
                backStackEntry?.destination?.route ?: MyCityScreen.Categories.name
            )
            
            MyCityTopAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        if (contentType == MyCityContentType.ListAndDetail) {
            MyCityExpandedAppContent(
                uiState = uiState,
                onCategoryClick = { viewModel.updateCurrentCategory(it) },
                onRecommendationClick = { viewModel.updateCurrentRecommendation(it) },
                modifier = Modifier.padding(innerPadding)
            )
        } else {
            MyCityCompactAppContent(
                uiState = uiState,
                onCategoryClick = {
                    viewModel.updateCurrentCategory(it)
                    navController.navigate(MyCityScreen.Recommendations.name)
                },
                onRecommendationClick = {
                    viewModel.updateCurrentRecommendation(it)
                    navController.navigate(MyCityScreen.Detail.name)
                },
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityTopAppBar(
    currentScreen: MyCityScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

@Composable
fun MyCityCompactAppContent(
    uiState: MyCityUiState,
    onCategoryClick: (Category) -> Unit,
    onRecommendationClick: (Recommendation) -> Unit,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MyCityScreen.Categories.name,
        modifier = modifier
    ) {
        composable(route = MyCityScreen.Categories.name) {
            CategoryList(
                categories = uiState.categories,
                onCategoryClick = onCategoryClick,
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(route = MyCityScreen.Recommendations.name) {
            RecommendationList(
                recommendations = uiState.recommendations,
                onRecommendationClick = onRecommendationClick,
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(route = MyCityScreen.Detail.name) {
            uiState.currentRecommendation?.let {
                RecommendationDetail(
                    recommendation = it,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun MyCityExpandedAppContent(
    uiState: MyCityUiState,
    onCategoryClick: (Category) -> Unit,
    onRecommendationClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        NavigationRail(
            modifier = Modifier.fillMaxHeight(),
        ) {
            uiState.categories.forEach { category ->
                val icon = when (category.id) {
                    1 -> Icons.Filled.Coffee
                    2 -> Icons.Filled.Restaurant
                    3 -> Icons.Filled.Park
                    4 -> Icons.Filled.Museum
                    else -> Icons.AutoMirrored.Filled.ArrowBack
                }
                NavigationRailItem(
                    selected = uiState.currentCategory == category,
                    onClick = { onCategoryClick(category) },
                    icon = { Icon(imageVector = icon, contentDescription = null) },
                    label = { Text(stringResource(category.titleRes)) }
                )
            }
        }
        
        Row(modifier = Modifier.weight(1f)) {
            RecommendationList(
                recommendations = uiState.recommendations,
                onRecommendationClick = onRecommendationClick,
                modifier = Modifier.width(300.dp)
            )
            uiState.currentRecommendation?.let {
                RecommendationDetail(
                    recommendation = it,
                    modifier = Modifier.weight(1f)
                )
            } ?: Text(
                text = "Select a recommendation",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
