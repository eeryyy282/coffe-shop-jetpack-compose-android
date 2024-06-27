package com.learnjetpackcompose.coffeeshopjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.learnjetpackcompose.coffeeshopjetpackcompose.ui.theme.CoffeeShopJetpackComposeTheme

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

}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetpackCoffeeAppPreview() {
    CoffeeShopJetpackComposeTheme {
        JetpackCoffeeApp()
    }
}