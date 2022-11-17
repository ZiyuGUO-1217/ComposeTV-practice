package com.composetv.ui.burgers

import com.composetv.StateViewModel
import com.composetv.data.BurgersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BurgersViewModel @Inject constructor(
    private val repository: BurgersRepository
): StateViewModel<BurgersUiState, BurgersUiAction, BurgersUiEvent>(){

    init {
        fetchData()
    }

    override fun configureInitState(): BurgersUiState {
        return BurgersUiState()
    }

    override fun dispatch(action: BurgersUiAction) = when (action) {
        else -> {}
    }

    private fun fetchData() {
        updateState {
            copy(burgers = repository.loadBurgers())
        }
    }

}
