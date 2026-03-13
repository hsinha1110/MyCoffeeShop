package com.himanshusinha.mycoffeeshop.presentation.ui_components

import kotlinx.serialization.Serializable

@Serializable
sealed class NavBarRoutes {

    @Serializable
    object HomeScreen : NavBarRoutes()

    @Serializable
    object CartScreen : NavBarRoutes()

    @Serializable
    object FavouriteScreen : NavBarRoutes()

    @Serializable
    object ProfileScreen : NavBarRoutes()

}