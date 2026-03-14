package com.himanshusinha.mycoffeeshop.presentation.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himanshusinha.mycoffeeshop.presentation.theme.LightBrown
import com.himanshusinha.mycoffeeshop.presentation.theme.LightGray

@Composable
fun CategoryChip(text: String, isSelected: Boolean = false, onSelected: () -> Unit) {
    Box(
        modifier = Modifier
            .width(90.dp)
            .height(30.dp)
            .clip(
                RoundedCornerShape(6.dp)
            )
            .clickable { onSelected() }
            .background(color = if (isSelected) LightBrown else Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, maxLines = 1, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryChipPreview() {
    CategoryChip(
        text = "Coffee",
        isSelected = true,
        onSelected = {}
    )
}