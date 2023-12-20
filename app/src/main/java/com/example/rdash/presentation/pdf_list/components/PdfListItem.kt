package com.example.rdash.presentation.pdf_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crypto.R
import com.example.rdash.domain.model.Data
import com.example.rdash.presentation.pdf_list.PdfEvent
import com.example.rdash.presentation.pdf_list.PdfListViewModel
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@Composable
fun PdfListItem(
    data: Data,
    viewModel: PdfListViewModel = hiltViewModel()
) {
    Row(
        modifier = Modifier
            .clickable { viewModel.onEvent(PdfEvent.PdfListItemClicked(data.file)) }
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(7.dp))
            .background(Color.White)
            .fillMaxWidth(),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = CenterVertically) {
            Image(
                painter = painterResource(
                    id = if (data.type == "DOC") R.drawable.pdf_icon else R.drawable.dwg_icon
                ),
                contentDescription = "fileType",
                modifier = Modifier.padding(12.dp)
            )

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = data.name,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                )

                Row {
                    Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFFFE3E4)) {
                        Text(
                            text = "V${data.version}",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 8.sp,
                                color = Color.Red
                            ),
                            modifier = Modifier.padding(2.dp),
                        )
                    }

                    Text(
                        text = "Uploaded On: ${convertDateTime(data.uploaded_at)}",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 10.sp,
                            color = Color(0xFF667085)
                        ),
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                }
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.three_dots_icon),
            contentDescription = "three dots",
            modifier = Modifier.padding(12.dp)
        )
    }
}

fun convertDateTime(inputDateTime: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d MMM, yy h:mma", Locale.getDefault())

    val date = inputFormat.parse(inputDateTime)
    outputFormat.timeZone = TimeZone.getTimeZone("GMT")

    return outputFormat.format(date)
}
