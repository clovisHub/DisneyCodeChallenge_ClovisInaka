package com.clovis.disneycodechallenge_clovisinaka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clovis.disneycodechallenge_clovisinaka.views.CreateConflictScreen
import com.clovis.disneycodechallenge_clovisinaka.views.SelectGuestViewScaffold
import com.clovis.uicomponents.ui.theme.DisneyCodeChallenge_ClovisInakaTheme
import com.clovis.uicomponents.ui.theme.screenBackgroundColor
import com.clovis.uicomponents.widgets.Demo_SwitchComponent
import com.clovis.uicomponents.widgets.Demo_SwitchComponent2

class SelectGuestActivity : ComponentActivity() {
    private val viewModel by lazy {
        SelectGuestViewModel(this@SelectGuestActivity.application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPopulationList()

        setContent {
            DisneyCodeChallenge_ClovisInakaTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = screenBackgroundColor
                ) {
                    //U used this because I am supposed to to used navHost dependency.
                    var navigationState by remember {
                        mutableStateOf(false)
                    }

                    if (navigationState) {
                        CreateConflictScreen()
                    } else {
                        SelectGuestViewScaffold(viewModel) { navigationState = it }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun displayComponent() {
    Demo_SwitchComponent()
}


@Preview
@Composable
fun displayComponent2() {
    Surface() {
        Demo_SwitchComponent2()
    }
}
