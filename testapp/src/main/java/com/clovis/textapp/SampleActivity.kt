package com.clovis.textapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clovis.textapp.ui.theme.DisneyCodeChallenge_ClovisInakaTheme
import com.clovis.textapp.ui.theme.parts.SetDashBoardContentList
import com.clovis.uicomponents.mixedwidgets.CreateFooterError
import com.clovis.uicomponents.mixedwidgets.CreateFooterWithIcon
import com.clovis.uicomponents.mixedwidgets.TextWithLeftCheckBox
import com.clovis.uicomponents.mixedwidgets.TopAppBar
import com.clovis.uicomponents.widgets.ButtonWith20by80Rounded
import com.clovis.uicomponents.widgets.ButtonWith44by343Rounded
import com.clovis.uicomponents.widgets.HeaderTextFieldSize18


class SampleActivity : ComponentActivity() {
    private val viewModel by lazy { SampleViewModel() }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDashBoardMocks()

        setContent {
            DisneyCodeChallenge_ClovisInakaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                "Select Guests", ImageVector
                                    .vectorResource(id = R.drawable.ic_baseline_arrow_back)
                            ) {

                            }
                        }
                    ) {
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
                                SetDashBoardContentList(viewModel, { enableButton.value = it }) {
                                    displayBottomError.value = it
                                }
                            }
                            Column(Modifier.weight(2.1f, true)) {
                                if (!enableButton.value && displayBottomError.value) {
                                    CreateFooterError(0)
                                } else {
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
}


@Preview
@Composable
fun Greeting() {
    DisneyCodeChallenge_ClovisInakaTheme {
        ButtonWith20by80Rounded(text = "rounded 20 by 80", onClick = {})
    }
}

@Preview
@Composable
fun DefaultPreview() {
    DisneyCodeChallenge_ClovisInakaTheme {
        ButtonWith44by343Rounded(text = "rounded 44 by 343", onClick = {}, enabled = true)
    }
}

@Preview
@Composable
fun DefaultPreview343() {
    DisneyCodeChallenge_ClovisInakaTheme {
        HeaderTextFieldSize18("Continue") {}
    }
}

@Preview
@Composable
fun TextFieldWithCheckPreview() {
    DisneyCodeChallenge_ClovisInakaTheme {
        TextWithLeftCheckBox(true, "Jeremy Gibson") {
            //checkbox current value is the "it"
        }
    }
}

@Preview
@Composable
fun TextFieldWithCheckFalsePreview() {
    DisneyCodeChallenge_ClovisInakaTheme {
        TextWithLeftCheckBox(false, "") {}
    }
}

@Preview
@Composable
fun FooterWithIcon() {
    DisneyCodeChallenge_ClovisInakaTheme {
        CreateFooterWithIcon(
            "At least one Guest in the party must have a reservation." +
                    " Guests without reservations must remain in the same booking party in order to " +
                    "enter."
        )
    }
}

@Preview
@Composable
fun ScrollableColumnDemo() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {
        for (i in 1..200) {
            Text(
                text = "Person $i",
                fontSize = 36.sp,
                modifier = Modifier.padding(8.dp)
            )
            Row(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxHeight()
                    .width(1.dp)
            ) {}
        }
    }
}
