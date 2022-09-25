package com.clovis.uicomponents.mixedwidgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.clovis.uicomponents.R
import com.clovis.uicomponents.widgets.CreateBottomFooterErrorImage
import com.clovis.uicomponents.widgets.ErrorTextForFooterTitles
import com.clovis.uicomponents.widgets.ErrorTextForFooters

@Composable
fun CreateFooterError(errorCode: Int) {

    Row(
        Modifier
            .background(color = Color.Black)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.End
    ) {
        Column(Modifier.weight(10F)) {
            ErrorTextForFooterTitles(stringResource(ErrorWrapper.getErrorData(errorCode).title))
            ErrorTextForFooters(stringResource(ErrorWrapper.getErrorData(errorCode).message))
        }
        Column(
            Modifier
                .padding(0.dp, 32.dp, 10.dp, 0.dp)
                .weight(1F)
                .clip(RoundedCornerShape(50.dp))
                .width(35.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            CreateBottomFooterErrorImage(ImageVector.vectorResource(id = R.drawable.ic_baseline_cancel_24)) {}
        }
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

