package com.himanshusinha.mycoffeeshop.presentation.screens.favouritescreen

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.himanshusinha.mycoffeeshop.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreenTopBar(navController: NavHostController) {

    CenterAlignedTopAppBar(

        title = {
            Text(
                text = "Favourite",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black

        ),



        )

}

@Preview(showBackground = true)
@Composable
fun FavouriteScreenTopBarPreview() {

    val navController = rememberNavController()

    FavouriteScreenTopBar(navController)

}