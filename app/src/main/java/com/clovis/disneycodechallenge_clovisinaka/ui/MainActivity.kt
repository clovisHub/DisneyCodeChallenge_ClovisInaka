package com.clovis.disneycodechallenge_clovisinaka.ui.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.clovis.disneycodechallenge_clovisinaka.ui.SelectGuestViewModel
import com.clovis.textapp.ui.theme.parts.SetDashBoardContentList
import com.clovis.uicomponents.ui.theme.DisneyCodeChallenge_ClovisInakaTheme
import com.clovis.uicomponents.widgets.ButtonWith44by343Rounded
import com.clovis.uicomponents.widgets.TopAppBar

class SelectGuestActivity : ComponentActivity() {
    private val viewModel by lazy { SelectGuestViewModel() }
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDashBoardMocks()

        setContent {
            DisneyCodeChallenge_ClovisInakaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
                    val yes = androidx.appcompat.R.drawable.abc_ic_arrow_drop_right_black_24dp
                    Scaffold(
                        topBar = {
                            TopAppBar("Select Guests",yes, {} )
                        }
                    ) {
                        Column(Modifier
                            .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Bottom) {
                            val enableButton = remember {
                                mutableStateOf(viewModel.shouldEnableContinueButton())
                            }
                            Column(Modifier.weight(10f, true)) {
                                SetDashBoardContentList(viewModel) {
                                    enableButton.value = it
                                }
                            }
                            Column(Modifier.weight(2f, true)) {
                                ButtonWith44by343Rounded(text = "Continue",
                                    enabled = enableButton.value,
                                    onClick = {})
                            }
                        }
                    }
                }
            }
        }
    }
}

