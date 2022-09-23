package com.clovis.uicomponents.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CreateEmailField(
    content: String,
    label: String? = null,
    error: String? = null,
    param: (String) -> Unit
) {

    CreateTextEdit(content, label, error, null, param = param)
}

/**
 * Username
 */
@Composable
fun CreateUsernameField(
    content: String,
    label: String? = null,
    error: String? = null
) {
    var value by remember { mutableStateOf(content) }
    CreateTextEdit(value, label, error, null, param = { result -> value = result })
}

/**
 * Password
 */
@Composable
fun CreatePasswordField(content: String, label: String? = null, error: String? = null) {
    var passwordValue by remember { mutableStateOf(content) }
    CreateTextEdit(passwordValue, label, error, 10, param = { result -> passwordValue = result })
}


/**
 * EditText With Blue Border
 */
@SuppressLint("PrivateResource")
@Composable
fun CreateTextEdit(
    value: String,
    label: String? = null,
    error: String? = null,
    leadingIcon: Int? = null,
    param: (String) -> Unit
) {
    //Label
    label?.let {
        val marginTop = if (error != null) 2.dp else 10.dp
        val marginBottom = if (error != null) 0.dp else 10.dp

        Text(
            modifier = Modifier
                .padding(20.dp, marginTop, 0.dp, marginBottom),
            text = AnnotatedString(it)
        )
    }
    //TextField Container
    Column(
        Modifier
            .padding(20.dp, 5.dp, 20.dp, 15.dp)
            .border(BorderStroke(1.5.dp, Color.Blue))
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp)),
        verticalArrangement = Arrangement.Center,
        // below line is used for specifying
        // horizontal arrangement.
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .defaultMinSize(200.dp, 50.dp)
                .fillMaxWidth()
                .padding(3.dp, 0.dp, 5.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            //Leading Icon
            var requireWidth = 310.dp
            if (getLeadingIcon(leadingIcon) != null && value.isNotEmpty()) {
                getLeadingIcon(leadingIcon)?.let { imageNumber ->
                    requireWidth = 290.dp
                    Icon(modifier = Modifier
                        .padding(0.dp, 0.dp, 4.dp, 0.dp)
                        .clickable { param("") }
                        .size(20.dp),
                        imageVector = ImageVector.vectorResource(id = imageNumber),
                        contentDescription = "Closed Icon")
                }
            }

            BasicTextField(
                value = value,
                onValueChange = { result -> param(result) },
                modifier = Modifier
                    .padding(3.dp, 0.dp, 3.dp, 0.dp)
                    .background(Color.White, RectangleShape)
                    .requiredWidth(requireWidth),
                maxLines = 1,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    textIndent = TextIndent(10.sp, 10.sp),
                    fontFamily = FontFamily.SansSerif,
                    lineHeight = 3.sp,
                    letterSpacing = 2.sp,
                    baselineShift = BaselineShift(-0.1f)
                ),
                singleLine = true
            )
            //End Icon
            if (value.isNotEmpty()) {
//                Icon(modifier = Modifier
//                    .padding(0.dp, 0.dp, 4.dp, 0.dp)
//                    .clickable { param("") }
//                    .size(20.dp),
//                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_m3_chip_close),
//                    contentDescription = "Closed Icon")
            }
        }
    }
    //Red Error field
    error?.let {
        Text(
            modifier = Modifier
                .padding(20.dp, 2.dp, 0.dp, 10.dp),
            text = AnnotatedString(it),
            fontSize = 12.sp,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif,
            maxLines = 1,
            color = Color.Red,
            style = TextStyle(
                color = Color.Red,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                textIndent = TextIndent(4.sp, 10.sp),
                fontFamily = FontFamily.SansSerif,
                lineHeight = 3.sp,
                letterSpacing = 2.sp,
                baselineShift = BaselineShift(-0.1f)
            )
        )
    }
}

/**
 * Icons With Their Numbers
 */
fun getLeadingIcon(it: Int?): Int? {
    return when (it) {
        0 -> null
        else -> null
    }
}