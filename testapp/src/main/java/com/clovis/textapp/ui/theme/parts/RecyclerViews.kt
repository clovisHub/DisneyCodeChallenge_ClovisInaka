package com.clovis.textapp.ui.theme.parts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clovis.textapp.SampleViewModel
import com.clovis.textapp.mocks.ContentType
import com.clovis.textapp.mocks.DashBoardContent
import com.clovis.uicomponents.mixedwidgets.CreateFooterWithIcon
import com.clovis.uicomponents.mixedwidgets.TextWithLeftCheckBox
import com.clovis.uicomponents.widgets.HeaderTextFieldSize18


/**
 * Dashboard RecyclerView
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetDashBoardContentList(
    viewModel: SampleViewModel,
    enableButton: (Boolean) -> Unit,
    displayError: (Boolean) -> Unit
) {

    val headers = viewModel
        .getDashBoardMocks()
        .filter { it.contentType == ContentType.SECTION }

    val grouped = viewModel
        .getDashBoardMocks()
        .groupBy { it.sectionNumber }

    LazyColumn {
        grouped.forEach { (section, sectionPersons) ->
            stickyHeader {
                headers.forEach {
                    if(it.sectionNumber == section) HeaderTextFieldSize18(it.name)
                }
            }

            items(count = sectionPersons.size) { index ->
                val dashBoardDataItem = sectionPersons[index]
                when (dashBoardDataItem.contentType) {
                    ContentType.PERSON -> {
                        TextWithLeftCheckBox(dashBoardDataItem.isCheck, dashBoardDataItem.name) {
                            dashBoardDataItem.isCheck = it
                            viewModel.updateItemSelectionState(dashBoardDataItem)
                            enableButton(viewModel.shouldEnableContinueButton())
                            displayError(viewModel.shouldDisplayBottomError())
                        }
                    }
                    ContentType.FOOTER -> {
                        CreateFooterWithIcon(dashBoardDataItem.name)
                    }
                    else -> {}
                }
            }
        }
    }
}