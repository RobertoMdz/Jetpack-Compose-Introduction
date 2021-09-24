package com.roberthmdz.jetpackcomposeintroduction.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roberthmdz.jetpackcomposeintroduction.ui.theme.Montserrat

@Composable
fun Screen3(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "Screen 3",
            style = MaterialTheme.typography.h1
        )

        Spacer(modifier = Modifier
            .height(8.dp)
            .fillMaxWidth()
        )
        Text(
            text = "Screen 3",
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier
            .height(8.dp)
            .fillMaxWidth()
        )

        Text(
            text = "Screen 3",
            style = MaterialTheme.typography.h3
        )
        Text(
            text = "Screen 3",
            style = TextStyle(
                color = Color.Black,
                fontSize = 42.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Montserrat
            )
        )
        Text(
            text = "Screen 3",
            style = TextStyle(
                color = Color.Black,
                fontSize = 42.sp,
                fontWeight = FontWeight.Light,
                fontFamily = Montserrat
            )
        )
        Text(
            text = "Screen 3",
            style = TextStyle(
                color = Color.Black,
                fontSize = 42.sp,
                fontWeight = FontWeight.Thin,
                fontFamily = Montserrat
            )
        )
    }
}