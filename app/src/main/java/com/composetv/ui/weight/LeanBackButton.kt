package com.composetv.ui.weight

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.semantics.Role

@Composable
fun TvLeanBackButton(
    shouldFocus: Boolean = false,
    onItemSelected: () -> Unit = {},
    isEnable: Boolean = true,
    content: @Composable BoxScope.(isFocused: Boolean) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .then(if (shouldFocus) Modifier.focusRequester(focusRequester) else Modifier)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = isEnable,
                role = Role.Button,
                onClick = onItemSelected
            ),
        content = { content(isFocused) }
    )

    if (shouldFocus) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

@Composable
fun TvLeanBackButton(
    shouldFocus: Boolean,
    onKeyEvent: (type: KeyEvent) -> Boolean,
    content: @Composable BoxScope.(isFocused: Boolean) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .then(if (shouldFocus) Modifier.focusRequester(focusRequester) else Modifier)
            .focusable(interactionSource = interactionSource)
            .onKeyEvent(onKeyEvent),
        content = { content(isFocused) }
    )

    if (shouldFocus) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

