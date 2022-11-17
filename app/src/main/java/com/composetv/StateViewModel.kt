package com.composetv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class StateViewModel<UiState, UiAction, UiEvent> : ViewModel() {
    protected abstract fun configureInitState(): UiState
    abstract fun dispatch(action: UiAction)

    private val _uiState by lazy {
        MutableStateFlow(configureInitState())
    }

    val uiState by lazy {
        _uiState.asStateFlow()
    }

    protected var state
        get() = _uiState.value
        private set(value) {
            _uiState.value = value
        }

    protected fun updateState(block: UiState.() -> UiState) {
        state = block(state)
    }

    private val _events by lazy {
        MutableSharedFlow<UiEvent>()
    }

    val events by lazy {
        _events.asSharedFlow()
    }

    protected fun sendEvent(event: UiEvent) {
        viewModelScope.launch {
            _events.emit(event)
        }
    }
}
