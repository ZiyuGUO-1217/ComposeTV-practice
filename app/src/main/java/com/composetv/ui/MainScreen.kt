package com.composetv.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun MainScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Welcome to ComposeTV!",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
