package com.himanshusinha.mycoffeeshop.presentation.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himanshusinha.mycoffeeshop.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MySearchBar() {
    var search by remember { mutableStateOf(value = "") }

    // Search + Filter Row
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {

        // Search Box
        Box(
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
                .background(
                    Color(0xFF2A2A2A), RoundedCornerShape(12.dp)
                ), contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextField(
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color(0xFF2A2A2A),
                        focusedContainerColor = Color(0xFF422A24),
                        cursorColor = Color.LightGray,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.Gray
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    value = search,
                    onValueChange = { search = it },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.regular_outline_search),
                            modifier = Modifier.size(20.dp),
                            contentDescription = "Search",
                            tint = Color.LightGray
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp),
                    placeholder = {
                        Text(
                            text = "Search Coffee", fontSize = 18.sp, color = Color.LightGray
                        )
                    })
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        // Filter Button
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(
                    Color(0xFFC67C4E), RoundedCornerShape(
                        topStart = 0.dp, bottomStart = 0.dp, topEnd = 12.dp, bottomEnd = 12.dp
                    )
                ), contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.regular_outline_filter),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}