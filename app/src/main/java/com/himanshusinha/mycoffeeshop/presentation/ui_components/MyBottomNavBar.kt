package com.himanshusinha.firstapp.jetpackcompose.c10_navigation

import kotlinx.serialization.Serializable

// Sealed class creates a restricted hierarchy
// So its subclasses can only be defined in the same file

// Each subclass of sealed class can have its own data and behavior
@Serializable
sealed class NavBarRoutes {

    @Serializable
    object HomeScreen : NavBarRoutes()
    // "LoginScreen"

    @Serializable
    object CartScreen : NavBarRoutes()
    @Serializable
    object FavouriteScreen : NavBarRoutes()
    @Serializable
    object ProfileScreen : NavBarRoutes()


}