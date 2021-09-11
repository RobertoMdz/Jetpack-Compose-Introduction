package com.roberthmdz.jetpackcomposeintroduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposable()
        }
    }
}

@Composable
fun SimpleComposable() {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

        // Two ways to set items in list

        // First set only one item in the list like this
        item {
            Text(
                text = "Producto de supermercado",
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black,
                ),
            )
        }

        // Second set many items in the list like this
        /*items(productList) { item ->
            ProductItem(product = item)
        }*/

        // itemsIndexed allow to implement logical inside the scopeList like this
        // Insert an advertising item every 5 position
        itemsIndexed(productList) { position, product ->
            if(position%5 == 0 && position != 0) {
                LazyRow {
                    items(advertisingList) {item ->
                        AdvertisingItem(advertising = item)
                    }
                }
            } else {
                ProductItem(product = product)
            }
        }
    }

}

@Composable
fun AdvertisingItem(advertising: Advertising) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(140.dp)
            .clip(RoundedCornerShape(12))
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = advertising.title,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun ProductItem(product: Product) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = product.name,
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "${product.price} MXN"
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    SimpleComposable()
}


data class Product(val name: String, val price: Double)

data class Advertising(val title: String)

private val productList = listOf(
    Product(name = "Manzana", price = 23.9),
    Product(name = "Pera", price = 23.9),
    Product(name = "Durazno", price = 23.9),
    Product(name = "Manzana", price = 23.9),
    Product(name = "Piña", price = 23.9),
    Product(name = "Lechuga", price = 23.9),
    Product(name = "Zanahoria", price = 23.9),
    Product(name = "Manzana", price = 23.9),
    Product(name = "Pera", price = 23.9),
    Product(name = "Durazno", price = 23.9),
    Product(name = "Manzana", price = 23.9),
    Product(name = "Piña", price = 23.9),
    Product(name = "Lechuga", price = 23.9),
    Product(name = "Zanahoria", price = 23.9)
)

private val advertisingList = listOf(
    Advertising("Publicidad 1"),
    Advertising("Publicidad 2"),
    Advertising("Publicidad 3"),
    Advertising("Publicidad 4"),
    Advertising("Publicidad 5"),
)