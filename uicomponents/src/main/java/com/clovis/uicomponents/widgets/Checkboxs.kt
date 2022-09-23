package com.clovis.uicomponents.widgets

import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun CreateCheckbox(checked: Boolean? = null, modifier: Modifier, onValueChange: (Boolean) -> Unit) {
    val isChecked = remember { mutableStateOf(checked ?: false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
            onValueChange(it)
        },
        modifier = Modifier
    )
}