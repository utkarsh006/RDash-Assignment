package com.example.rdash.presentation.pdf_list.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    text: String,
    fontWeight: FontWeight,
    fontSize: Float
) {
    Text(
        text = text,
        style = TextStyle(
            fontWeight = fontWeight,
            fontSize = fontSize.sp,
        )
    )
}