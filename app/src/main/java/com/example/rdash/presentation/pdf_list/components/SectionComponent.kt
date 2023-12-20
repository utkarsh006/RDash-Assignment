package com.example.rdash.presentation.pdf_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crypto.R
import com.example.rdash.domain.model.Data

@Composable
fun SectionComponent(
    sectionTitle: String,
    designsList: List<Data>
) {
    val collapsedState = remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                TextComponent(
                    text = sectionTitle,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16f
                )

                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFEBEBEB)) {
                    Text(
                        text = "${designsList.size} Files",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Color(0xFF3D3D52)
                        ),
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }

            Icon(
                painter = if (collapsedState.value) painterResource(id = R.drawable.collapsed_arrow)
                else painterResource(id = R.drawable.expanded_arrow),
                contentDescription = "expandSection",
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
                    .clickable { collapsedState.value = !collapsedState.value }
            )
        }

        if (!collapsedState.value) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(designsList) { data ->
                    PdfListItem(data = data)
                }
            }
        }

    }
}