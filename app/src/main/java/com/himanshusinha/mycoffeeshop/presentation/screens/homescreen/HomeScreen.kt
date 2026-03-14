package com.himanshusinha.mycoffeeshop.presentation.screens.homescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.himanshusinha.mycoffeeshop.R
import com.himanshusinha.mycoffeeshop.domain.model.Product
import com.himanshusinha.mycoffeeshop.presentation.navigation.MyNavBar
import com.himanshusinha.mycoffeeshop.presentation.ui_components.MySearchBar

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun HomeScreen(navController: NavHostController) {

    val location = "Janatha Rd,Palarivattom"

    val products = listOf(
        Product(1, "Espresso", "Strong and Rich", 3.80, R.drawable.coffee_2),
        Product(2, "Latte", "Smooth and Creamy", 4.50, R.drawable.coffee_3),
        Product(3, "Americano", "With chocolate", 4.20, R.drawable.coffee_1),
        Product(4, "Macchiato", "With cocoa flavour", 4.70, R.drawable.coffee_4),
        Product(5, "Cappuccino", "Cold and milky", 4.60, R.drawable.coffee_5),
        Product(6, "Flat White", "Velvety smooth", 4.40, R.drawable.coffee_6),
        Product(7, "Iced Mocha", "Refreshing and rich", 4.70, R.drawable.coffee_4)
    )

    Scaffold(
        bottomBar = { MyNavBar(navController) }
    ) { innerPadding ->

        Box(modifier = Modifier.fillMaxSize()) {

            // Gradient Background
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.35f)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF303030),
                                Color(0xFF1F1F1F),
                                Color(0xFF121212)
                            )
                        )
                    )
            )

            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {

                item {
                    Text(
                        text = "Location",
                        color = Color.Gray,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = location,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )

                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Change Location",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    MySearchBar()

                    Spacer(modifier = Modifier.height(24.dp))

                    Image(
                        painter = painterResource(R.drawable.banner_1),
                        contentDescription = "Banner",
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    HomeScreenCategories()

                    Spacer(modifier = Modifier.height(20.dp))
                }

                items(products.chunked(2)) { rowItems ->
                    Row(modifier = Modifier.fillMaxWidth()) {

                        // Both cards with clickable but no ripple effect
                        ProductCard(
                            product = rowItems[0],
                            modifier = Modifier
                                .weight(1f)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) {
                                    navController.navigate("details/${rowItems[0].id}")
                                }
                        )

                        if (rowItems.size > 1) {
                            ProductCard(
                                product = rowItems[1],
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = null
                                    ) {
                                        navController.navigate("details/${rowItems[1].id}")
                                    }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavbarHomeScreenPreview() {
    HomeScreen(rememberNavController())
}