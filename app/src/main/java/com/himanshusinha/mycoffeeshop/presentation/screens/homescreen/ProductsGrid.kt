package com.himanshusinha.mycoffeeshop.presentation.screens.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshusinha.mycoffeeshop.R
import com.himanshusinha.mycoffeeshop.domain.model.Product

@Composable
fun ProductsGrid(
    products: List<Product>,
    topContent: @Composable () -> Unit,
    onProductClick: (Product) -> Unit   // callback for click
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        item {
            topContent()
        }

        items(products.chunked(2)) { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                ProductCard(
                    product = rowItems[0],
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onProductClick(rowItems[0]) }
                )

                if (rowItems.size > 1) {
                    ProductCard(
                        product = rowItems[1],
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onProductClick(rowItems[1]) }
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsGridPreview() {

    // Sample list of products
    val sampleProducts = listOf(
        Product(
            id = 1,
            name = "Espresso",
            description = "Strong and Rich",
            price = 3.80,
            imageResource = R.drawable.coffee_1
        ),
        Product(
            id = 2,
            name = "Latte",
            description = "Smooth and Creamy",
            price = 4.50,
            imageResource = R.drawable.coffee_2
        ),
        Product(
            id = 3,
            name = "Cappuccino",
            description = "Rich Espresso with Milk",
            price = 4.20,
            imageResource = R.drawable.coffee_3
        ),
        Product(
            id = 4,
            name = "Americano",
            description = "With Chocolate",
            price = 4.00,
            imageResource = R.drawable.coffee_1
        )
    )

    ProductsGrid(
        products = sampleProducts,
        topContent = {
            // Optional top composable
            androidx.compose.material3.Text(
                text = "Featured Products",
                modifier = Modifier.padding(16.dp)
            )
        },
        onProductClick = { product ->
            // For preview, just log name
            println("Clicked: ${product.name}")
        }
    )
}