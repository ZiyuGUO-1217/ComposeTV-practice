package com.composetv.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MyTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme {
        content()
    }
}
