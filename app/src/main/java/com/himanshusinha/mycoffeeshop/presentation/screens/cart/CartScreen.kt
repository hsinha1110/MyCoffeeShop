package com.himanshusinha.mycoffeeshop.presentation.screens.cart


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.himanshusinha.mycoffeeshop.domain.model.Product
import com.himanshusinha.mycoffeeshop.presentation.navigation.MyNavBar
import com.himanshusinha.mycoffeeshop.R
import com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen.CartScreenTopBar

@Composable
fun CartScreen(
    navController: NavHostController,
    product: Product?
){

    Scaffold(
        topBar = { CartScreenTopBar(navController) },
        bottomBar = { MyNavBar(navController) }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            if (product != null) {
                Text(
                    text = product.name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text("Cart Empty")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {

    val navController = rememberNavController()

    val sampleProduct = Product(
        id = 1,
        name = "Espresso",
        description = "Strong and Rich",
        price = 3.80,
        imageResource = R.drawable.coffee_2
    )

    CartScreen(
        navController = navController,
        product = sampleProduct
    )
}