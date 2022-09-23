package com.clovis.textapp.ui.theme.parts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.clovis.disneycodechallenge_clovisinaka.ui.SelectGuestViewModel
import com.clovis.textapp.SampleViewModel
import com.clovis.textapp.mocks.ContentType
import com.clovis.textapp.mocks.DashBoardContent
import com.clovis.uicomponents.mixedwidgets.CreateFooterWithIcon
import com.clovis.uicomponents.mixedwidgets.TextWithLeftCheckBox
import com.clovis.uicomponents.widgets.HeaderTextFieldSize18


/**
 * Dashboard RecyclerView
 */
@Composable
fun SetDashBoardContentList(
    viewModel: SelectGuestViewModel,
    enableButton: (Boolean) -> Unit
) {
    val dashBoardContents: List<DashBoardContent> = viewModel.getDashBoardMocks()

    LazyColumn {
        items(count = dashBoardContents.size) { index ->
            val dashBoardDataItem = dashBoardContents[index]
            when (dashBoardDataItem.contentType) {
                ContentType.SECTION -> {
                    HeaderTextFieldSize18(dashBoardDataItem.name)
                }
                ContentType.PERSON -> {
                    TextWithLeftCheckBox(dashBoardDataItem.isCheck, dashBoardDataItem.name) {
                        dashBoardDataItem.isCheck = it
                        viewModel.updateItemSelectionState(dashBoardDataItem)
                        enableButton(viewModel.shouldEnableContinueButton())
                    }
                }
                ContentType.FOOTER -> {
                    CreateFooterWithIcon(dashBoardDataItem.name)
                }
                // else -> { Do not do anything }
            }
        }
    }
}