package com.composetv.ui.burgers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.composetv.R
import com.composetv.model.Burger
import com.composetv.ui.padding
import com.composetv.ui.weight.ContentPage

@Composable
fun BurgersScreen() {
    val viewModel: BurgersViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    ContentPage(titleId = R.string.content_title_burger) {
        BurgersDetails(state.burgers)
    }
}

@Composable
fun BurgersDetails(burgers: List<Burger>) {
    val lazyGridState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.content_item_width)),
        state = lazyGridState,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = R.dimen.card_shadow),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.content_item_horizontal_spacing)),
        userScrollEnabled = false
    ) {
        items(burgers.size) { index ->
            BurgerCard(burgers[index])
        }
    }
}
