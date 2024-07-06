package com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SectionText(
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun SectionTextPreview() {
    SectionText(title = "Title Section Text")
}