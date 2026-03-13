package com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.himanshusinha.mycoffeeshop.presentation.ui_components.NavBarRoutes
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenBottomAppBar(navController: NavHostController) {

    BottomAppBar(
        containerColor = Color.White
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Price",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "$4.53",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC67C4E)
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate(NavBarRoutes.CartScreen)                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC67C4E)
                )
            ) {
                Text(
                    text = "Add To Cart",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenBottomAppBarPreview() {

    val navController = rememberNavController()

    DetailScreenBottomAppBar(navController)

}