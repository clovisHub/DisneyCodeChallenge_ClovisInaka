package com.clovis.disneycodechallenge_clovisinaka.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.clovis.dataprovider.data.models.PopulationType
import com.clovis.disneycodechallenge_clovisinaka.R
import com.clovis.disneycodechallenge_clovisinaka.SelectGuestViewModel
import com.clovis.disneycodechallenge_clovisinaka.parts.SetDashBoardContentList
import com.clovis.uicomponents.mixedwidgets.CreateFooterError
import com.clovis.uicomponents.mixedwidgets.TopAppBar
import com.clovis.uicomponents.widgets.ButtonWith44by343Rounded


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectGuestViewScaffold(viewModel: SelectGuestViewModel,  navigate: (Boolean) -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                stringResource(id = R.string.select_guest_toolbar_tile),
                ImageVector.vectorResource(id = R.drawable.ic_baseline_arrow_back)
            ) {

            }
        }
    ) { contentPadding ->

        val populationListState by remember {
            mutableStateOf(viewModel.getPopulationListCoroutines())
        }

        Column(Modifier.padding(contentPadding)) {
            CreateSelectGuestViewContent(
                viewModel = viewModel,
                populationListState = populationListState,
                navigate
            )
        }
    }
}

@Composable
fun CreateSelectGuestViewContent(viewModel: SelectGuestViewModel,
                          populationListState:List<PopulationType>,
                                 navigate: (Boolean) -> Unit) {
    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        val enableButton = remember {
            mutableStateOf(viewModel.shouldEnableContinueButton())
        }

        val displayBottomError = remember {
            mutableStateOf(viewModel.shouldDisplayBottomError())
        }
        Column(Modifier.weight(9.7f, true)) {
            if (populationListState.isEmpty()) {
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }

            } else {
                SetDashBoardContentList(populationListState,
                    viewModel,
                    { enableButton.value = it }) {
                    displayBottomError.value = it
                }
            }
        }
        Column(Modifier.weight(2.1f, true)) {
            if (!enableButton.value && displayBottomError.value) {
                CreateFooterError(0)
            } else {
                ButtonWith44by343Rounded(text = stringResource(
                    id = R.string.select_guest_continue_btn
                ),
                    enabled = enableButton.value,
                    onClick = {
                         if(enableButton.value) {
                             //Switch view here with navHost but since we can't add dependencies ...
                             // I used this way
                              enableButton.value = false
                              navigate(true)
                         } else {
                             //Do not anything yet
                         }
                    }
                )
            }
        }
    }
}