package com.clovis.uicomponents.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun CreateToolbarImage(imageVector: ImageVector, onIconClick: () -> Unit) {
    Row {
        CreateDrawableVectorIconImage(
            UiImageObject(
                vectorImage = imageVector,
                contentDescription = "Top App Bar Icon",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .clickable(onClick = onIconClick)
                    .size(35.dp)
                    .padding(9.dp, 0.dp, 6.dp, 0.dp)
                    .align(Alignment.CenterVertically)
            )
        )
    }
}

@Composable
fun CreateFooterImages(imageVector: ImageVector) {
    Row {
        CreateDrawableVectorIconImage(
            UiImageObject(
                vectorImage = imageVector,
                contentDescription = "Footer image",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .size(35.dp)
                    .padding(9.dp, 0.dp, 6.dp, 0.dp)
                    .align(Alignment.CenterVertically)
            )
        )
    }
}


@Composable
fun CreateBottomFooterErrorImage(imageVector: ImageVector, onIconClick: () -> Unit) {
    Row() {
        CreateDrawableVectorIconImage(
            UiImageObject(
                vectorImage = imageVector,
                contentDescription = "Top App Bar Icon",
                colorFilter = ColorFilter.lighting(Color.Black, Color.Black),
                modifier = Modifier
                    .clickable(onClick = onIconClick)
                    .background(color = Color.White)
                    .size(width = 41.dp, height = 28.dp)
                    .clip(RoundedCornerShape(50.dp))
                    //.padding(9.dp, 0.dp, 6.dp, 0.dp)
                    .align(Alignment.CenterVertically)
            )
        )
    }
}


/**
 * imageVector: ImageVector,
 * contentDescription: String?,
 * modifier: Modifier = Modifier,
 * colorFilter: ColorFilter? = null
 */
@Composable
private fun CreateDrawableVectorIconImage(uidImageObject: UiImageObject) {
    Icon(imageVector = uidImageObject.vectorImage,
        contentDescription = uidImageObject.contentDescription,
        modifier = uidImageObject.modifier)
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
        painter = uidImageObject.painter!!,
        contentDescription = uidImageObject.contentDescription,
        colorFilter = uidImageObject.colorFilter,
        modifier = uidImageObject.modifier
    )
}

private data class UiImageObject(
    val vectorImage: ImageVector,
    val contentDescription: String?,
    var modifier: Modifier = Modifier,
    val alignment: Alignment = Alignment.Center,
    val contentScale: ContentScale = ContentScale.Fit,
    val alpha: Float = DefaultAlpha,
    val colorFilter: ColorFilter? = null,
    val painter: Painter? = null
)