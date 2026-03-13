package com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.himanshusinha.mycoffeeshop.R
import com.himanshusinha.mycoffeeshop.domain.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetails(navController: NavHostController, product: Product?) {

    Scaffold(
        topBar = {
            DetailsScreenTopAppBar(navController)
        },
        bottomBar = { DetailScreenBottomAppBar(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {

                // Product Image
                if (product != null) {
                    Image(
                        painter = painterResource(id = product.imageResource),
                        contentDescription = product.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )

                    DetailsContentScreen(product)
                } else {
                    Text(text = "Product not found", color = Color.White)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    val sampleProduct = Product(
        id = 1,
        name = "Espresso",
        description = "Strong and Rich",
        price = 3.80,
        imageResource = R.drawable.coffee_2,
    )
    ProductDetails(navController = rememberNavController(), product = sampleProduct)
}