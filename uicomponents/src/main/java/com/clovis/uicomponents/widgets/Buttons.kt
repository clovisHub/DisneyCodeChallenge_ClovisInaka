package com.clovis.uicomponents.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clovis.uicomponents.ui.theme.buttonDisableColor
import com.clovis.uicomponents.ui.theme.buttonDisableContentColor


@Composable
fun ButtonWithRoundedCorners(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean? = null,
    onClick: () -> Unit
) {
    CreateButton(
        UIButtonsObject(
            text,
            modifier
                .padding(10.dp, 20.dp, 10.dp, 20.dp)
                .fillMaxWidth(),
            enabled = enabled ?: true,
            shape = RoundedCornerShape(15.dp),
            elevation = ButtonDefaults.elevatedButtonElevation()
        ),
        onClick = onClick
    )
}

@Composable
fun ButtonWithRectangleCorners(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean? = null,
    onClick: () -> Unit
) {
    CreateButton(
        UIButtonsObject(
            text,
            modifier
                .padding(20.dp, 20.dp, 20.dp, 20.dp)
                .fillMaxWidth(),
            enabled = enabled ?: true,
            shape = RectangleShape
        ),
        onClick = onClick
    )
}

@Composable
fun ButtonWith20by80(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean? = null,
    onClick: () -> Unit
) {
    CreateButton(
        UIButtonsObject(
            text,
            modifier
                .padding(10.dp, 20.dp, 10.dp, 20.dp)
                .defaultMinSize(80.dp, 50.dp),
            enabled = enabled ?: true,
            shape = RectangleShape
        ),
        onClick = onClick
    )
}


@Composable
fun ButtonWith20by80Rounded(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean? = null,
    onClick: () -> Unit
) {

    CreateButton(
        UIButtonsObject(
            text,
            modifier = modifier
                .padding(10.dp, 20.dp, 10.dp, 20.dp)
                .defaultMinSize(80.dp, 20.dp),
            enabled = enabled ?: true,
            shape = RoundedCornerShape(22.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp
            )
        ),
        onClick = onClick
    )
}

@Composable
fun ButtonWith44by343Rounded(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit
) {

    Column(Modifier
        .fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center) {
        CreateButton(
            UIButtonsObject(
                text = text,
                modifier = modifier
                    .padding(16.dp, 16.dp, 16.dp, 34.dp)
                    .size(343.dp, 44.dp),
                enabled = enabled,
                shape = RoundedCornerShape(22.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
                ),
                textSize = 16
            ),
            onClick = onClick
        )
    }
}


/**
 * Button
 */
@Composable
fun CreateButton(uiButtonsObjects: UIButtonsObject, onClick: () -> Unit) {
    Button(
        { onClick() },
        modifier = uiButtonsObjects.modifier,
        enabled = uiButtonsObjects.enabled,
        interactionSource = remember { MutableInteractionSource() },
        elevation = uiButtonsObjects.elevation,
        shape = uiButtonsObjects.shape ?: RectangleShape,
        border = null,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = buttonDisableColor
        )
    ) {

        Text(
            text = uiButtonsObjects.text,
            fontSize = uiButtonsObjects.textSize.sp,
            fontFamily = uiButtonsObjects.fontFamily,
            color = uiButtonsObjects.disabledContentrColor
        )
    }
}


data class UIButtonsObject(
    val text: String,
    var modifier: Modifier,
    var enabled: Boolean,
    var elevation: ButtonElevation? = null,
    var shape: Shape? = null,
    var textSize: Int = 12,
    var fontFamily: FontFamily = FontFamily.Default,
    var disabledContainerColor: Color = buttonDisableColor,
    var disabledContentrColor: Color = buttonDisableContentColor
)
