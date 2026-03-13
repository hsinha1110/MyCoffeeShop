package com.himanshusinha.mycoffeeshop.presentation.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.himanshusinha.mycoffeeshop.R
import com.himanshusinha.mycoffeeshop.presentation.ui_components.NavBarRoutes

@Composable
fun MyNavBar(navController: NavHostController) {

    val navItems = listOf(
        NavItem("Home", R.drawable.regular_outline_home, NavBarRoutes.HomeScreen),
        NavItem("Cart", R.drawable.regular_outline_bag, NavBarRoutes.CartScreen),
        NavItem("Favourite", R.drawable.regular_outline_heart, NavBarRoutes.FavouriteScreen),
        NavItem("Profile", R.drawable.outline_account_circle_24, NavBarRoutes.ProfileScreen)
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route

    NavigationBar {

        navItems.forEach { item ->

            NavigationBarItem(
                selected = currentRoute == item.routes::class.qualifiedName,

                onClick = {

                    navController.navigate(item.routes) {

                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                },

                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(30.dp)
                    )
                },

                label = { Text(item.title) },

                alwaysShowLabel = true,

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFC67C4E),
                    selectedTextColor = Color(0xFFC67C4E),
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = Color(0xFFC67C4E).copy(alpha = 0.1f)
                )
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: Int,
    val routes: NavBarRoutes
)

@Preview(showBackground = true)
@Composable
fun MyNavBarPreview() {

    val navController = rememberNavController()

    MyNavBar(navController)
}