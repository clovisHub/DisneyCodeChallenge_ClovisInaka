package com.clovis.uicomponents.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CreateToolbarImage(icon: Int, onIconClick: () -> Unit) {
    Row {
        CreateDrawableImage(
            UiImageObject(
                painter = painterResource(icon),
                contentDescription = "Top App Bar Icon",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .clickable(onClick = onIconClick)
                    .size(22.dp)
                    .padding(9.dp, 0.dp, 6.dp, 0.dp)
                    .align(Alignment.CenterVertically)
            )
        )
    }
}


@Composable
fun CreateFooterImages(icon: Int) {
    Row {
        CreateDrawableImage(
            UiImageObject(
                painter = painterResource(icon),
                contentDescription = "Top App Bar Icon",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .size(22.dp)
                    .padding(9.dp, 0.dp, 6.dp, 0.dp)
                    .align(Alignment.CenterVertically)
            )
        )
    }
}


@Composable
fun CreateBottomFooterErrorImage(icon: Int, onIconClick: () -> Unit) {
    Row {
        CreateDrawableImage(
            UiImageObject(
                painter = painterResource(icon),
                contentDescription = "Top App Bar Icon",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .clickable(onClick = onIconClick)
                    .size(22.dp)
                    .padding(9.dp, 0.dp, 6.dp, 0.dp)
                    .align(Alignment.CenterVertically)
            )
        )
    }
}


/**
 * painter: Painter,
 * contentDescription: String?,
 * modifier: Modifier = Modifier,
 * alignment: Alignment = Alignment.Center,
 * contentScale: ContentScale = ContentScale.Fit,
 * alpha: Float = DefaultAlpha,
 * colorFilter: ColorFilter? = null
 */
@Composable
private fun CreateDrawableImage(uidImageObject: UiImageObject) {
    Image(
        painter = uidImageObject.painter,
        contentDescription = uidImageObject.contentDescription,
        colorFilter = uidImageObject.colorFilter,
        modifier = uidImageObject.modifier
    )
}

private data class UiImageObject(
    val painter: Painter,
    val contentDescription: String?,
    var modifier: Modifier = Modifier,
    val alignment: Alignment = Alignment.Center,
    val contentScale: ContentScale = ContentScale.Fit,
    val alpha: Float = DefaultAlpha,
    val colorFilter: ColorFilter? = null
)