package com.learnjetpackcompose.coffeeshopjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learnjetpackcompose.coffeeshopjetpackcompose.model.dummyCategory
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components.CategoryItem
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components.Search
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components.SectionText
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.theme.CoffeeShopJetpackComposeTheme
import com.learnjetpackcompose.coffeshopjetpackcompose.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeShopJetpackComposeTheme {
                JetpackCoffeeApp()
            }
        }
    }
}

@Composable
fun JetpackCoffeeApp() {
    Column {
        Banner()
        SectionText(stringResource(R.string.section_category))
        CategoryRow()
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Composable
fun CategoryRow() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category = category)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun JetpackCoffeeAppPreview() {
    CoffeeShopJetpackComposeTheme {
        JetpackCoffeeApp()
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPreview() {
    CoffeeShopJetpackComposeTheme {
        CategoryRow()
    }

}