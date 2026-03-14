package com.himanshusinha.mycoffeeshop.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.himanshusinha.mycoffeeshop.domain.model.Product
import com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen.ProductDetails
import com.himanshusinha.mycoffeeshop.presentation.screens.cart.CartScreen
import com.himanshusinha.mycoffeeshop.screens.ProfileScreen.ProfileScreen
import com.himanshusinha.mycoffeeshop.presentation.screens.homescreen.HomeScreen
import com.himanshusinha.mycoffeeshop.R
import com.himanshusinha.mycoffeeshop.presentation.screens.favouritescreen.FavouriteScreen
import com.himanshusinha.mycoffeeshop.presentation.screens.welcomescreen.WelcomeScreen
import com.himanshusinha.mycoffeeshop.presentation.ui_components.NavBarRoutes

@Composable
fun NavbarNavigation() {

    val navController = rememberNavController()
    val products = listOf(
        Product(1, "Espresso", "Strong and Rich", 3.80, R.drawable.coffee_2),
        Product(2, "Latte", "Smooth and Creamy", 4.50, R.drawable.coffee_3),
        Product(3, "Americano", "With chocolate", 4.20, R.drawable.coffee_1),
        Product(4, "Macchiato", "With cocoa flavour", 4.70, R.drawable.coffee_4),
        Product(5, "Cappuccino", "Cold and milky", 4.60, R.drawable.coffee_5),
        Product(6, "Flat White", "Velvety smooth", 4.40, R.drawable.coffee_6),
        Product(7, "Iced Mocha", "Refreshing and rich", 4.70, R.drawable.coffee_4)
    )
    NavHost(
        navController = navController,
        startDestination = NavBarRoutes.WelcomeScreen
    ) {

        composable<NavBarRoutes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<NavBarRoutes.HomeScreen> {
            HomeScreen(navController = navController)
        }

        composable<NavBarRoutes.FavouriteScreen> {
            FavouriteScreen(navController = navController)
        }

        composable<NavBarRoutes.ProfileScreen> {
            ProfileScreen(navController = navController)
        }

        composable<NavBarRoutes.CartScreen> {
            CartScreen(navController = navController  )
        }

        // Details Screen with product object
        composable("details/{productId}") { backStackEntry ->

            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            val product = products.find { it.id == productId }

            ProductDetails(navController = navController, product = product)
        }


    }

}