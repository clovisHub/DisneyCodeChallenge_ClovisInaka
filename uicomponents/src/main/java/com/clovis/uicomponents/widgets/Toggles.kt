package com.clovis.uicomponents.widgets


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Switch
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Demo_SwitchComponent2() {
    var switchCheckedState by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Switch(
            modifier = Modifier
                .height(100.dp)
                .width(200.dp),
            checked = switchCheckedState,
            onCheckedChange = { switchCheckedState = it },
            thumbContent = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                    tint = Color.Gray
                )
            },
            colors =  SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                checkedTrackColor = Color(0xFF03A9F4),
                checkedBorderColor= Color.Blue,
                checkedIconColor = Color.Blue,
                uncheckedThumbColor = Color.Blue,
                uncheckedTrackColor = Color(0xFF6CA8C4),
                uncheckedIconColor= Color.Green,
                uncheckedBorderColor = Color.Blue,

                disabledCheckedThumbColor = Color.Blue,
                disabledCheckedTrackColor = Color(0xFF6CA8C4),
                disabledCheckedBorderColor= Color.Blue,
                disabledCheckedIconColor = Color.Blue,
                disabledUncheckedThumbColor = Color.Yellow,
                disabledUncheckedTrackColor = Color.Black,
                disabledUncheckedIconColor= Color.Green,
                disabledUncheckedBorderColor = Color.Blue,
            )
        )
    }
}

@Composable
fun Demo_SwitchComponent() {
    var switchCheckedState by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Switch(
            modifier = Modifier.width(150.dp),
            checked = switchCheckedState,
            onCheckedChange = { switchCheckedState = it },
            colors = SwitchDefaults.colors(
                //Enabled checked
                checkedThumbColor = Color.Blue,
                checkedTrackColor = Color(0xFF03A9F4),
                checkedBorderColor= Color.Blue,
                checkedIconColor = Color.Blue,
                //Enabled unchecked
                uncheckedThumbColor = Color.Blue,
                uncheckedTrackColor = Color(0xFF03A9F4),
                uncheckedIconColor= Color.Green,
                uncheckedBorderColor = Color.Blue,
                //disabled checked and unchecked
                disabledCheckedThumbColor = Color.Blue,
                disabledCheckedTrackColor = Color(0xFF6CA8C4),
                disabledCheckedBorderColor= Color.Blue,
                disabledCheckedIconColor = Color.Blue,
                disabledUncheckedThumbColor = Color.Yellow,
                disabledUncheckedTrackColor = Color.Black,
                disabledUncheckedIconColor= Color.Green,
                disabledUncheckedBorderColor = Color.Blue,
            )
        )
    }
}