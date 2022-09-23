package com.clovis.uicomponents.mixedwidgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clovis.uicomponents.R
import com.clovis.uicomponents.widgets.CreateFooterImages
import com.clovis.uicomponents.widgets.TextForFooters

@Composable
fun CreateFooterWithIcon(value: String) {
    Row(
        modifier = Modifier
            .padding(15.dp, 16.dp, 15.dp, 16.dp)
    ) {

        CreateFooterImages(icon = R.drawable.ic_launcher_foreground)
        TextForFooters(value)
    }
}