package com.clovis.uicomponents.mixedwidgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.clovis.uicomponents.R
import com.clovis.uicomponents.widgets.CreateBottomFooterErrorImage
import com.clovis.uicomponents.widgets.ErrorTextForFooters

@Composable
fun CreateFooterError(errorCode: Int) {

    Row(
        Modifier
            .height(93.dp)
            .fillMaxWidth()
    ) {
        Column(
        ) {
            ErrorTextForFooters(stringResource(ErrorWrapper.getErrorData(errorCode).title))
            ErrorTextForFooters(stringResource(ErrorWrapper.getErrorData(errorCode).message))
        }
        CreateBottomFooterErrorImage(icon = R.drawable.ic_baseline_cancel_24, {})
    }
}

private data class ErrorCodeData(val title: Int, val message: Int)

private object ErrorWrapper {

    private var errorMap: MutableMap<Int, ErrorCodeData> = mutableMapOf()

    init {
        errorMap[0] = ErrorCodeData(
            R.string.error_reservation_needed,
            R.string.error_select_at_least
        )
        //errorMap[1] = ErrorCodeData(R.string.error_title, R.string.error_title)
    }

    fun getErrorData(errorCode: Int): ErrorCodeData {
        return errorMap[errorCode] ?: ErrorCodeData(R.string.error_title, R.string.error_message)
    }
}

