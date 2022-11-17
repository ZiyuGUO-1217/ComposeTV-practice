package com.composetv.ui.burgers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.composetv.R
import com.composetv.model.Burger
import com.composetv.ui.padding
import com.composetv.ui.theme.black
import com.composetv.ui.theme.gray
import com.composetv.ui.theme.mainContentTextStyle
import com.composetv.ui.theme.priceTextStyle
import com.composetv.ui.theme.subContentTextStyle
import com.composetv.ui.theme.white
import com.composetv.ui.theme.yellow

@Composable
fun BurgerCard(burger: Burger) {
    Card(
        modifier = Modifier
            .padding(top = R.dimen.content_item_top_padding, bottom = R.dimen.content_item_bottom_padding)
            .requiredSize(
                width = dimensionResource(id = R.dimen.content_item_width),
                height = dimensionResource(id = R.dimen.content_item_height)
            ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.content_item_corner_radius)),
        elevation = dimensionResource(id = R.dimen.card_shadow),
        backgroundColor = white,
        contentColor = Color.Transparent
    ) {
        var isImageLoading by remember { mutableStateOf<Boolean>(false) }

        val image = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(burger.imageUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Fit,
            onLoading = { isImageLoading = true },
            onSuccess = { isImageLoading = false }
        )
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemImage(image, isImageLoading)
                NameText(burger.name)
                WeightText(burger.weight)
                PriceText(burger.price)
            }
        }
    }
}

@Composable
private fun ItemImage(image: AsyncImagePainter, isImageLoading: Boolean) {
    Box {
        Image(
            painter = image,
            contentDescription = "image",
            modifier = Modifier.requiredHeight(dimensionResource(id = R.dimen.content_item_image_height))
        )
        if (isImageLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.icon_size))
                    .align(Alignment.Center),
                color = gray
            )
        }
    }
}

@Composable
private fun NameText(name: String) {
    Text(
        text = name,
        style = mainContentTextStyle,
        color = black,
        modifier = Modifier,
        maxLines = 1
    )
}

@Composable
private fun WeightText(weight: String) {
    Text(
        text = weight,
        style = subContentTextStyle,
        color = gray,
        modifier = Modifier.padding(top = R.dimen.content_item_description_top_padding),
        maxLines = 1
    )
}

@Composable
private fun PriceText(price: String) {
    Text(
        text = price,
        style = priceTextStyle,
        color = yellow,
        modifier = Modifier.padding(top = R.dimen.content_item_price_top_padding),
        maxLines = 1
    )
}
