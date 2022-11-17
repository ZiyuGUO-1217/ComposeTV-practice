package com.composetv.ui.weight

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.composetv.R
import com.composetv.ui.padding
import com.composetv.ui.theme.black
import com.composetv.ui.theme.gray
import com.composetv.ui.theme.lightGray
import com.composetv.ui.theme.searchBarTextStyle
import com.composetv.ui.theme.topBarTextStyle
import com.composetv.ui.theme.yellow

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .padding(horizontal = R.dimen.detail_page_horizontal_padding)
            .padding(top = R.dimen.detail_page_horizontal_padding)
            .height(dimensionResource(id = R.dimen.topbar_height))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.topbar_icon_size))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.item_corner_radius_medium)))
                .background(lightGray),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_back),
                contentDescription = "back",
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.icon_size))
                    .align(Alignment.Center),
                tint = Color.Unspecified
            )
        }
        HorizontalSpacer(width = R.dimen.topbar_title_start_padding)
        Text(
            text = stringResource(R.string.top_bar_title),
            modifier = Modifier.weight(1f),
            style = topBarTextStyle,
            color = black
        )
        TextField(
            value = stringResource(id = R.string.search_bar_placeholder),
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_search),
                    contentDescription = stringResource(id = R.string.search_bar_placeholder),
                    modifier = Modifier.requiredSize(dimensionResource(id = R.dimen.search_bar_icon_size)),
                    tint = gray
                )
            },
            textStyle = searchBarTextStyle,
            modifier = Modifier
                .fillMaxHeight()
                .width(dimensionResource(id = R.dimen.search_bar_width))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.item_corner_radius_medium))),
            colors = TextFieldDefaults.textFieldColors(
                textColor = gray,
                backgroundColor = lightGray,
                placeholderColor = gray,
                focusedIndicatorColor = yellow,
            )
        )
    }
}


@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}

