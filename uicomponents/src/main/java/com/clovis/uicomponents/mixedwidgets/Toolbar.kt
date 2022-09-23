package com.clovis.uicomponents.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clovis.uicomponents.ui.theme.headerColor

@Composable
fun TopAppBar(
    title: String,
    icon: Int,
    onIconClick: () -> Unit,
) {

    androidx.compose.material.TopAppBar(
        modifier = Modifier
            .height(56.dp)
            .background(color = headerColor)
            .fillMaxWidth(),
        backgroundColor = headerColor
    ) {
        CreateToolbarImage(icon, onIconClick)

        ToolbarTexts(title)
    }
}
