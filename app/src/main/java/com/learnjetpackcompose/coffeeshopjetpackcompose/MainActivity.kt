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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learnjetpackcompose.coffeeshopjetpackcompose.model.Menu
import com.learnjetpackcompose.coffeeshopjetpackcompose.model.dummyBestSellerMenu
import com.learnjetpackcompose.coffeeshopjetpackcompose.model.dummyCategory
import com.learnjetpackcompose.coffeeshopjetpackcompose.model.dummyMenu
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components.CategoryItem
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components.HomeSection
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components.MenuItem
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.components.Search
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.model.BottomBarItem
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
    Scaffold(
        bottomBar = { ButtonBar() },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                Banner()
                HomeSection(
                    title = stringResource(id = R.string.section_category),
                    content = { CategoryRow() })

                HomeSection(title = stringResource(id = R.string.menu_favorite), content = {
                    MenuRow(
                        listMenu = dummyMenu
                    )
                })

                HomeSection(
                    title = stringResource(id = R.string.section_best_seller_menu),
                    content = {
                        MenuRow(
                            listMenu = dummyBestSellerMenu
                        )
                    })
            }
        })
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
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category = category)
        }

    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu = menu)
        }
    }

}

@Composable
fun ButtonBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
    ) {
        val navigationItem = listOf(
            BottomBarItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            BottomBarItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            )
        )
        navigationItem.map {
            NavigationBarItem(
                selected = it.title == navigationItem[0].title,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                label = {
                    Text(
                        it.title
                    )
                })
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