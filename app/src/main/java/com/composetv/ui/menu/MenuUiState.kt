package com.composetv.ui.menu

data class MenuUiState(
    val selectedItem: Int = 1
)

sealed interface MenuUiAction {
    object KeyUp: MenuUiAction
    object KeyDown: MenuUiAction
    object KeySelected: MenuUiAction
}

sealed interface MenuUiEvent {
    object FocusBelowItem: MenuUiEvent
}
