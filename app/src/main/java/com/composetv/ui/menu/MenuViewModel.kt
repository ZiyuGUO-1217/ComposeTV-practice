package com.composetv.ui.menu

import com.composetv.StateViewModel
import com.composetv.model.MenuItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(): StateViewModel<MenuUiState, MenuUiAction, MenuUiEvent>() {

    override fun configureInitState(): MenuUiState {
        return MenuUiState()
    }

    override fun dispatch(action: MenuUiAction) {
        when (action) {
            MenuUiAction.KeyUp -> onKeyUp()
            MenuUiAction.KeyDown -> onKeyDown()
            MenuUiAction.KeySelected -> onKeySelected()
        }
    }

    private fun onKeyUp() {
        val preSelected = state.selectedItem
        if (preSelected == 0) return
        updateState { copy(selectedItem = preSelected - 1) }
    }

    private fun onKeyDown() {
        val preSelected = state.selectedItem
        if (preSelected == MenuItem.values().lastIndex) {
            sendEvent(MenuUiEvent.FocusBelowItem)
        } else {
            updateState { copy(selectedItem = preSelected + 1) }
        }
    }

    private fun onKeySelected() {

    }
}
