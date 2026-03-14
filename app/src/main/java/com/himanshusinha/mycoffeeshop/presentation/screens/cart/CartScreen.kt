package com.himanshusinha.mycoffeeshop.presentation.screens.cart

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen.CartScreenTopBar
import com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen.DetailScreenBottomAppBar
import com.himanshusinha.mycoffeeshop.presentation.theme.LightBrown
import com.himanshusinha.mycoffeeshop.presentation.theme.LightGray
import com.himanshusinha.mycoffeeshop.presentation.ui_components.NavBarRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {

    var expanded by remember { mutableStateOf(false) }
    var selectedMode by remember { mutableStateOf("Cash") }
    val interactionSource = remember { MutableInteractionSource() }

    val cartProducts = listOf(
        Product(1, "Espresso", "Strong and Rich", 3.80, R.drawable.coffee_2),
        Product(2, "Latte", "Smooth and Creamy", 4.50, R.drawable.coffee_3),
        Product(3, "Americano", "With chocolate", 4.20, R.drawable.coffee_1)
    )

    val subtotal = cartProducts.sumOf { it.price }
    val deliveryFee = 1.5
    val total = subtotal + deliveryFee


    Scaffold(
        topBar = {
            CartScreenTopBar(navController)
        },
        bottomBar = { MyNavBar(navController) },


        ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            item {

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Deliver",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightBrown
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            items(cartProducts) { product ->

                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(Color.White)
                ) {

                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(product.imageResource),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {

                            Text(product.name, fontWeight = FontWeight.Bold)

                            Text(
                                product.description,
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }

                        Text("+", fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("0")
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("-", fontSize = 20.sp)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
            }

            item {

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Payment Summary",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Price")
                    Text("$${"%.2f".format(subtotal)}")
                }

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Delivery Fee")
                    Text("$${"%.2f".format(deliveryFee)}")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    colors = CardDefaults.cardColors(LightGray),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Box {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null
                                ) {
                                    expanded = true
                                }
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(R.drawable.mobile_banking),
                                contentDescription = null,
                                modifier = Modifier.size(28.dp),
                                colorFilter = ColorFilter.tint(LightBrown)
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Column(modifier = Modifier.weight(1f)) {

                                Text(selectedMode, fontWeight = FontWeight.Bold)

                                Text("$13.5", color = LightBrown)
                            }

                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {

                            DropdownMenuItem(

                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(R.drawable.mobile_banking),
                                        contentDescription = "Online",
                                        tint = LightBrown,
                                        modifier = Modifier.size(25.dp)
                                    )
                                },
                                text = { Text("Online") },
                                onClick = {
                                    selectedMode = "Online"
                                    expanded = false
                                }
                            )

                            DropdownMenuItem(
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(R.drawable.wallet),
                                        contentDescription = "Cash",
                                        tint = LightBrown,
                                        modifier = Modifier.size(25.dp)
                                    )
                                },
                                text = { Text("Cash") },
                                onClick = {
                                    selectedMode = "Cash"
                                    expanded = false
                                }
                            )
                        }
                    }

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFC67C4E),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Placed Order",
                            fontSize = 18.sp
                        )

                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {

    val navController = rememberNavController()

    CartScreen(
        navController = navController
    )
}