package com.composetv.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.composetv.R

enum class MenuItem(@DrawableRes val iconId: Int, @StringRes val textId: Int) {
    DASHBOARD(iconId = R.drawable.menu_dashboard, textId = R.string.menu_dashboard),
    FOOD_AND_DRINKS(iconId = R.drawable.menu_foods, textId = R.string.menu_food_and_drinks),
    MESSAGES(iconId = R.drawable.menu_message, textId = R.string.menu_message),
    BILLS(iconId = R.drawable.menu_bills, textId = R.string.menu_bills),
    SETTINGS(iconId = R.drawable.menu_settings, textId = R.string.menu_settings),
    SUPPORT(iconId = R.drawable.menu_support, textId = R.string.menu_support)
}
