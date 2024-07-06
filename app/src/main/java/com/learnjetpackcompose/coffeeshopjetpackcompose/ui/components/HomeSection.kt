package com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeSection(
    title: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
    ) {
        SectionText(title = title, modifier = modifier)
        content()
    }
}