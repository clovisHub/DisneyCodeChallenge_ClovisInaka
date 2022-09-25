package com.clovis.disneycodechallenge_clovisinaka.parts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import com.clovis.dataprovider.data.models.PopulationContentType
import com.clovis.dataprovider.data.models.PopulationType
import com.clovis.disneycodechallenge_clovisinaka.SelectGuestViewModel
import com.clovis.uicomponents.mixedwidgets.CreateFooterWithIcon
import com.clovis.uicomponents.mixedwidgets.TextWithLeftCheckBox
import com.clovis.uicomponents.widgets.HeaderTextFieldSize18


/**
 * Dashboard RecyclerView
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetDashBoardContentList(
    populationList: List<PopulationType>,
    viewModel: SelectGuestViewModel,
    enableButton: (Boolean) -> Unit,
    displayError: (Boolean) -> Unit
) {

    val headers = populationList
        .filter { it.contentType == PopulationContentType.SECTION }

    val groupedPopulation = populationList
        .groupBy { it.sectionNumber }
        .toSortedMap()

    LazyColumn {
        groupedPopulation.forEach { (section, sectionPersons) ->
            stickyHeader {
                headers.forEach {
                    if (it.sectionNumber == section) HeaderTextFieldSize18(it.name)
                }
            }

            items(count = sectionPersons.size) { index ->
                val dashBoardDataItem = sectionPersons[index]
                when (dashBoardDataItem.contentType) {
                    PopulationContentType.PERSON -> {
                        TextWithLeftCheckBox(dashBoardDataItem.isCheck, dashBoardDataItem.name) {
                            dashBoardDataItem.isCheck = it
                            viewModel.updateItemSelectionState(dashBoardDataItem)
                            enableButton(viewModel.shouldEnableContinueButton())
                            displayError(viewModel.shouldDisplayBottomError())
                        }
                    }
                    PopulationContentType.FOOTER -> {
                        CreateFooterWithIcon(dashBoardDataItem.name)
                    }
                    else -> {}
                }
            }
        }
    }
}
