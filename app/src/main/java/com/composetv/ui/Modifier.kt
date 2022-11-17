package com.composetv.ui

import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

fun Modifier.padding(
    @DimenRes start: Int? = null,
    @DimenRes top: Int? = null,
    @DimenRes end: Int?= null,
    @DimenRes bottom: Int?= null,
) = composed {
    padding(
        start = start?.let { dimensionResource(id = it) } ?: 0.dp,
        top = top?.let { dimensionResource(id = it) } ?: 0.dp,
        end = end?.let { dimensionResource(id = it) } ?: 0.dp,
        bottom = bottom?.let { dimensionResource(id = it) } ?: 0.dp
    )
}

fun Modifier.padding(
    @DimenRes vertical: Int? = null,
    @DimenRes horizontal: Int? = null
) = composed {
    padding(
        vertical = vertical?.let { dimensionResource(id = it) } ?: 0.dp,
        horizontal = horizontal?.let { dimensionResource(id = it) } ?: 0.dp,
    )
}

fun Modifier.padding(@DimenRes all: Int) = composed {
    padding(
        all = dimensionResource(id = all)
    )
}
