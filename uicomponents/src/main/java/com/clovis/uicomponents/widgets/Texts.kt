package com.clovis.uicomponents.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clovis.uicomponents.ui.theme.footerColor
import com.clovis.uicomponents.ui.theme.headerTextColor
import com.clovis.uicomponents.ui.theme.headerTitleColor


@Composable
fun HeaderTextFieldSize18(title: String? = null, onTextChange: (TextLayoutResult) -> Unit = {}) {

    if (!title.isNullOrBlank()) {
        Row(modifier = Modifier)
        {
            CreateText(
                uiTextObject = UITextObject(
                    text = title,
                    modifier = Modifier
                        .padding(16.dp, 20.dp, 16.dp, 20.dp),
                    fontSize = 18,
                    color = headerTitleColor,
                    onTextLayout = onTextChange
                )
            )
        }
    }
}

@Composable
fun ToolbarTexts(title: String) {
    Row() {
        CreateText(
            UITextObject(
                text = title,
                color = headerTextColor,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                fontSize = 16,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp, end = 35.dp)
                    .fillMaxWidth()
            )
        )
    }
}

@Composable
fun ErrorTextForFooters(value: String? = null) {
    val footer by remember { mutableStateOf(value) }
    if (value.isNullOrBlank().not()) {
        CreateText(
            uiTextObject = UITextObject(
                modifier = Modifier.padding(6.dp, 0.dp, 0.dp, 0.dp),
                text = footer ?: "",
                fontSize = 14,
                color = footerColor,
                maxLines = 1,
                onTextLayout = {}
            )
        )
    }
}

@Composable
fun CheckboxTexts(value: String? = null) {
    val footer by remember { mutableStateOf(value) }
    if (value.isNullOrBlank().not()) {
        CreateText(
            uiTextObject = UITextObject(
                text = value ?: "no value",
                maxLines = 1,
                fontSize = 16,
                onTextLayout = {}
            )
        )
    }
}


@Composable
fun TextForFooters(value: String? = null) {
    val footer by remember { mutableStateOf(value) }
    if (value.isNullOrBlank().not()) {
        CreateText(
            uiTextObject = UITextObject(
                modifier = Modifier.padding(6.dp, 0.dp, 0.dp, 0.dp),
                text = footer ?: "",
                fontSize = 14,
                color = footerColor,
                maxLines = 1,
                onTextLayout = {}
            )
        )
    }
}

/**
 * Text widget has these variables below.
 *
 *
 * text: AnnotatedString,
 * modifier: Modifier = Modifier,
 * color: Color = Color.Unspecified,
 * fontSize: TextUnit = TextUnit.Unspecified,
 * fontStyle: FontStyle? = null,
 * fontWeight: FontWeight? = null,
 * fontFamily: FontFamily? = null,
 * letterSpacing: TextUnit = TextUnit.Unspecified,
 * textDecoration: TextDecoration? = null,
 * textAlign: TextAlign? = null,
 * lineHeight: TextUnit = TextUnit.Unspecified,
 * overflow: TextOverflow = TextOverflow.Clip,
 * softWrap: Boolean = true,
 * maxLines: Int = Int.MAX_VALUE,
 * inlineContent: Map<String, InlineTextContent> = mapOf(),
 * onTextLayout: (TextLayoutResult) -> Unit = {},
 * style: TextStyle = LocalTextStyle.current
 */
@Composable
private fun CreateText(uiTextObject: UITextObject) {
    Text(
        text = AnnotatedString(uiTextObject.text),
        modifier = uiTextObject.modifier,
        color = uiTextObject.color,
        fontSize = uiTextObject.fontSize.sp,
        fontStyle = uiTextObject.fontStyle,
        fontWeight = uiTextObject.fontWeight,
        fontFamily = uiTextObject.fontFamily,
        letterSpacing = uiTextObject.letterSpacing,
        textDecoration = uiTextObject.textDecoration,
        textAlign = uiTextObject.textAlign,
        lineHeight = uiTextObject.lineHeight,
        overflow = uiTextObject.overflow,
        onTextLayout = uiTextObject.onTextLayout,
        style = LocalTextStyle.current
    )
}

private data class UITextObject(
    val text: String,
    var modifier: Modifier = Modifier,
    var color: Color = Color.Unspecified,
    var fontSize: Int = 12,
    var fontStyle: FontStyle? = null,
    var fontFamily: FontFamily = FontFamily.Default,
    var fontWeight: FontWeight? = null,
    var letterSpacing: TextUnit = TextUnit.Unspecified,
    var textDecoration: TextDecoration? = null,
    var textAlign: TextAlign? = null,
    var lineHeight: TextUnit = TextUnit.Unspecified,
    var overflow: TextOverflow = TextOverflow.Clip,
    var softWrap: Boolean = true,
    var maxLines: Int = Int.MAX_VALUE,
    var inlineContent: Map<String, InlineTextContent> = mapOf(),
    var onTextLayout: (TextLayoutResult) -> Unit = {}
)

