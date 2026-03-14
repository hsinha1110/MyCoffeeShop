package com.himanshusinha.mycoffeeshop.presentation.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshusinha.mycoffeeshop.R

import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.himanshusinha.mycoffeeshop.domain.model.Product
import com.himanshusinha.mycoffeeshop.presentation.screens.homescreen.HomeScreen
import com.himanshusinha.mycoffeeshop.presentation.theme.LightBrown
import com.himanshusinha.mycoffeeshop.presentation.theme.LightGray


@Composable
fun CartItem(product: Product) {

    var quantity by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(product.imageResource),
                contentDescription = "Coffee Image"
            )

            Column(

                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
            ) {

                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.DarkGray
                    )
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {

                // PLUS
                IconButton(
                    onClick = { quantity++ },
                    modifier = Modifier
                        .size(10.dp)
                        .background(
                            color = LightBrown.copy(alpha = 0.1f),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.plus),
                        tint = LightBrown,
                        contentDescription = "Plus"
                    )
                }

                Text(
                    text = quantity.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                // MINUS
                IconButton(
                    onClick = {
                        if (quantity > 0) quantity--
                    },
                    enabled = quantity > 0,
                    modifier = Modifier
                        .size(10.dp)
                        .background(
                            color = LightBrown.copy(alpha = 0.1f),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.minus),
                        tint = LightBrown,
                        contentDescription = "Minus"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemPreview() {

    val product = Product(
        id = 1,
        name = "Cappuccino",
        description = "Rich espresso with steamed milk",
        price = 199.0,
        imageResource = R.drawable.coffee_3
    )

    CartItem(product = product)
}