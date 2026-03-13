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
import androidx.compose.ui.unit.dp
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