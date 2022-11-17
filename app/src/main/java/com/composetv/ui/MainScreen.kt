package com.composetv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.composetv.ui.theme.white

@Composable
fun MainScreen() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        MenuBar()
        ContentPage()
    }
}

@Preview(device = Devices.AUTOMOTIVE_1024p, showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
