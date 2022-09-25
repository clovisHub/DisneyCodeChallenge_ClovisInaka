package com.clovis.uicomponents.mixedwidgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.clovis.uicomponents.ui.theme.headerColor
import com.clovis.uicomponents.widgets.CreateToolbarImage
import com.clovis.uicomponents.widgets.ToolbarTexts

@Composable
fun TopAppBar(
    title: String,
    imageVector: ImageVector,
    onIconClick: () -> Unit,
) {

    androidx.compose.material.TopAppBar(
        modifier = Modifier
            .height(56.dp)
            .background(color = headerColor)
            .fillMaxWidth(),
        backgroundColor = headerColor
    ) {
        CreateToolbarImage(imageVector, onIconClick)

        ToolbarTexts(title)
    }
}
