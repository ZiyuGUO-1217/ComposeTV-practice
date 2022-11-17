package com.composetv.ui.weight

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.composetv.R
import com.composetv.model.MenuItem
import com.composetv.ui.padding
import com.composetv.ui.theme.black
import com.composetv.ui.theme.gray
import com.composetv.ui.theme.lightGray
import com.composetv.ui.theme.logoTextStyle
import com.composetv.ui.theme.menuItemTextStyle
import com.composetv.ui.theme.profileButtonTextStyle
import com.composetv.ui.theme.profileDetailsTextStyle
import com.composetv.ui.theme.profileNameTextStyle
import com.composetv.ui.theme.white
import com.composetv.ui.theme.yellow

@Composable
fun MenuBar() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(dimensionResource(id = R.dimen.menu_bar_width))
            .shadow(dimensionResource(id = R.dimen.page_divider_width))
    ) {
        LogoBar()
        MenuItems()
        Spacer(modifier = Modifier.weight(1f))
        ProfileCard()
    }
}

@Composable
private fun MenuItems() {
    MenuItem.values().forEachIndexed { index, menuItem ->
        MenuItem(
            iconId = menuItem.iconId,
            text = stringResource(id = menuItem.textId),
            isSelected = index == 1
        )
        if (index != MenuItem.values().lastIndex) {
            VerticalSpacer(height = R.dimen.menu_item_spacing)
        }
    }
}

@Composable
private fun LogoBar() {
    Row(
        modifier = Modifier
            .padding(
                top = R.dimen.logo_bar_top_padding,
                bottom = R.dimen.logo_bar_bottom_padding,
            )
            .padding(horizontal = R.dimen.logo_bar_horizontal_padding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo_item),
            contentDescription = "logo",
            modifier = Modifier.size(dimensionResource(id = R.dimen.logo_size)),
            tint = Color.Unspecified
        )
        HorizontalSpacer(width = R.dimen.logo_and_title_spacing)
        Text(
            text = stringResource(R.string.string_logo),
            style = logoTextStyle,
            color = black,
            maxLines = 1
        )
    }
}

@Composable
private fun MenuItem(
    @DrawableRes iconId: Int,
    text: String,
    isSelected: Boolean = false
) {
    val backgroundColor = if (isSelected) yellow else Color.Transparent
    Row(
        modifier = Modifier
            .padding(start = R.dimen.menu_item_start_padding, end = R.dimen.menu_item_end_padding)
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.item_corner_radius_medium)))
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier
                .padding(R.dimen.menu_item_icon_padding)
                .size(dimensionResource(id = R.dimen.icon_size)),
            tint = Color.Black
        )
        Text(
            text = text,
            style = menuItemTextStyle,
            color = black,
            maxLines = 1
        )
    }
}

@Composable
fun ProfileCard() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .padding(horizontal = R.dimen.profile_card_horizontal_padding)
                .padding(top = R.dimen.profile_image_offset, bottom = R.dimen.profile_card_bottom_padding)
                .height(dimensionResource(id = R.dimen.profile_card_height))
                .fillMaxWidth(),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.profile_card_corner_radius)),
            backgroundColor = white,
            elevation = dimensionResource(id = R.dimen.card_shadow),
            content = { ProfileDetails() }
        ) 
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile",
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.profile_image_size))
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        )
    }
}

@Composable
private fun ProfileDetails() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalSpacer(height = R.dimen.profile_name_top_padding)
        Text(text = stringResource(R.string.profile_name), style = profileNameTextStyle, color = black, maxLines = 1)
        VerticalSpacer(height = R.dimen.profile_details_top_padding)
        Text(text = stringResource(R.string.profile_details), style = profileDetailsTextStyle, color = gray, maxLines = 1)
        Button(
            onClick = {},
            modifier = Modifier
                .padding(
                    horizontal = R.dimen.profile_button_horizontal_padding,
                    vertical = R.dimen.profile_button_vertical_padding
                )
                .fillMaxSize(),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = lightGray,
                contentColor = black,
                disabledContentColor = white
            ),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.profile_card_corner_radius)),
            elevation = null,
            contentPadding = PaddingValues()
        ) {
            Text(text = stringResource(R.string.profile_button),style = profileButtonTextStyle, color = black, maxLines = 1)
        }
    }
}
