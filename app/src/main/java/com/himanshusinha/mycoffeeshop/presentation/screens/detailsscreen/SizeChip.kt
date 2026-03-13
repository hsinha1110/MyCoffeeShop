package com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SizeChip(
    size: String,
    selectedSize: String,
    onClick: () -> Unit
) {

    val isSelected = size == selectedSize

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(80.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isSelected) Color(0xFFC67C4E).copy(alpha = 0.1f)
                else Color(0xFFF2F2F2)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color(0xFFC67C4E) else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 10.dp)

    ) {

        Text(
            text = size,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = if (isSelected) Color(0xFFC67C4E) else Color.Black,
        )
    }
}