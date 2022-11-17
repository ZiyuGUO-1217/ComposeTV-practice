package com.composetv.ui.burgers

import com.composetv.model.Burger

data class BurgersUiState(
    val burgers: List<Burger> = emptyList()
)

sealed interface BurgersUiAction

sealed interface BurgersUiEvent
