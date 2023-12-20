package com.example.rdash.presentation.pdf_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crypto.R

@Composable
fun TopAppBar() {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        TextComponent(text = stringResource(id = R.string.design_layouts), fontWeight = FontWeight.Bold, fontSize = 14f)

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextComponent(text = stringResource(id = R.string.client), fontWeight = FontWeight.Normal, fontSize = 14f)

            Spacer(modifier = Modifier.width(4.dp))
            TextComponent(text = stringResource(id = R.string.bridgestone), fontWeight = FontWeight.W500, fontSize = 12f)

            Spacer(modifier = Modifier.width(4.dp))
            TextComponent(text = stringResource(id = R.string.pipe), fontWeight = FontWeight.Normal, fontSize = 10f)

            Spacer(modifier = Modifier.width(4.dp))
            TextComponent(text = stringResource(id = R.string.job_id), fontWeight = FontWeight.Normal, fontSize = 12f)

            Spacer(modifier = Modifier.width(4.dp))
            TextComponent(text = stringResource(id = R.string.brid), fontWeight = FontWeight.W500, fontSize = 12f)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.1f),
                        Color.Transparent,
                    )
                )
            )
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}