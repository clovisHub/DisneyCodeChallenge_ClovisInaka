package com.clovis.uicomponents.mixedwidgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clovis.uicomponents.widgets.CheckboxTexts
import com.clovis.uicomponents.widgets.CreateCheckbox


@Composable
fun TextWithLeftCheckBox(value: Boolean? = null, title: String, onValueChange: (Boolean) -> Unit) {

    Row() {

        val isChecked = remember { mutableStateOf(value ?: false) }

        CreateCheckbox(
            checked = isChecked.value,
            modifier = Modifier
                .padding(16.dp, 9.dp, 10.dp, 9.dp)
                .size(20.dp, if (isChecked.value) 16.dp else 20.dp)
                .align(Alignment.CenterVertically)
        ) {
            isChecked.value = it
            onValueChange(it)
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        {
            CheckboxTexts(title)
        }
    }
}
