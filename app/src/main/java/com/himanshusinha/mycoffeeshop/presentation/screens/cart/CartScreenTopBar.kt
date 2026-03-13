package com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen

import androidx.compose.foundation.layout.padding
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
fun CartScreenTopBar(navController: NavHostController) {

    CenterAlignedTopAppBar(

        title = {
            Text(
                text = "Order",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black

        ),

        navigationIcon = {

            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.regular_outline_arrow_left),
                    modifier = Modifier.size(25.dp),
                    contentDescription = "Heart Icon"
                )
            }

        },

    )

}

@Preview(showBackground = true)
@Composable
fun CartScreenTopBarPreview() {

    val navController = rememberNavController()

    CartScreenTopBar(navController)

}