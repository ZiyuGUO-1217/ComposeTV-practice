package com.composetv.ui.weight

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.composetv.R
import com.composetv.ui.padding
import com.composetv.ui.theme.black
import com.composetv.ui.theme.contentTitleTextStyle

@Composable
fun ContentPage(@StringRes titleId: Int, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = R.dimen.detail_page_horizontal_padding)
    ) {
        ContentTitle(titleId)
        content()
    }
}

@Composable
fun ContentTitle(@StringRes textId: Int) {
    VerticalSpacer(height = R.dimen.detail_page_top_padding)
    Text(
        text = stringResource(textId),
        style = contentTitleTextStyle,
        modifier = Modifier.padding(vertical = R.dimen.content_title_vertical_padding),
        color = black,
        maxLines = 1
    )
}
