package com.himanshusinha.mycoffeeshop.presentation.screens.detailsscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SizeSelector() {

    var selectedSize = remember { mutableStateOf("M") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        SizeChip("S", selectedSize.value) { selectedSize.value = "S" }
        SizeChip("M", selectedSize.value) { selectedSize.value = "M" }
        SizeChip("L", selectedSize.value) { selectedSize.value = "L" }

    }
}