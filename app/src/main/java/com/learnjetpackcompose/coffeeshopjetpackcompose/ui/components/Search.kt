package com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.theme.CoffeeShopJetpackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    modifier: Modifier = Modifier
) {
    SearchBar(
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .heightIn(min = 48.dp)
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    CoffeeShopJetpackComposeTheme {
        Search()
    }
}