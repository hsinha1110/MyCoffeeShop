package com.himanshusinha.mycoffeeshop.presentation.screens.favouritescreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.himanshusinha.mycoffeeshop.R
import com.himanshusinha.mycoffeeshop.domain.model.Product
import com.himanshusinha.mycoffeeshop.presentation.navigation.MyNavBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.himanshusinha.mycoffeeshop.presentation.ui_components.NavBarRoutes

@Composable
fun FavouriteScreen(navController: NavHostController) {

    val favouriteProducts = remember {
        mutableStateListOf(
            Product(1, "Espresso", "Strong and Rich", 3.80, R.drawable.coffee_2),
            Product(2, "Latte", "Smooth and Creamy", 4.50, R.drawable.coffee_3),
            Product(3, "Americano", "With chocolate", 4.20, R.drawable.coffee_1)
        )
    }


    Scaffold(
        topBar = { FavouriteScreenTopBar(navController) },
        bottomBar = { MyNavBar(navController) }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(favouriteProducts) { product ->

                FavouriteItem(
                    product = product,
                    onDelete = {
                        favouriteProducts.remove(product)
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FavouriteScreenPreview() {

    val navController = rememberNavController()

    FavouriteScreen(
        navController = navController
    )
}