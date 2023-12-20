package com.example.rdash.presentation.pdf_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crypto.R
import com.example.rdash.presentation.pdf_list.components.SectionComponent
import com.example.rdash.presentation.pdf_list.components.TopAppBar

@Composable
fun PdfListScreen(
    viewModel: PdfListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar()
        Spacer(modifier = Modifier.height(10.dp))

        MainScreenList()

        // If the error occurs
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(CenterHorizontally)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
        }
    }
}

@Composable
fun MainScreenList(viewModel: PdfListViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        SectionComponent(
            sectionTitle = stringResource(id = R.string.section_2d),
            designsList = state.data2D
        )

        Spacer(modifier = Modifier.height(10.dp))

        SectionComponent(
            sectionTitle = stringResource(id = R.string.section_3d),
            designsList = state.data3D
        )

        Spacer(modifier = Modifier.height(10.dp))

        SectionComponent(
            sectionTitle = stringResource(id = R.string.section_prod),
            designsList = state.dataProd
        )

    }
}

