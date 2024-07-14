package com.example.mvidemo.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvidemo.R
import com.example.mvidemo.ui.theme.MviDemoTheme

@Composable
fun TopNavigationBar(
    navViewModel: TopNavigationBarViewModel,
) {
    val state by navViewModel.container.stateFlow.collectAsState()
    val titleId = state.titleId

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        TopNavigationBarContent(
            modifier = Modifier.fillMaxSize(),
            titleId = titleId,
            onBack = { navViewModel.back() },
            onNext = { navViewModel.next() }
        )
    }
}

@Composable
fun TopNavigationBarContent(
    modifier: Modifier = Modifier,
    @StringRes titleId: Int,
    onBack: () -> Unit,
    onNext: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.padding(horizontal = 12.dp),
            onClick = onBack
        ) {
            Text(text = "Back")
        }
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = titleId),
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier.padding(horizontal = 12.dp),
            onClick = onNext
        ) {
            Text(text = "Next")
        }
    }

}

@Preview
@Composable
private fun TopNavigationBarPreview() {
    MviDemoTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            TopNavigationBarContent(
                modifier = Modifier.fillMaxSize(),
                titleId = R.string.main_title,
                onBack = {},
                onNext = {}
            )
        }
    }
}