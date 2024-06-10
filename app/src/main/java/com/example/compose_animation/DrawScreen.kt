package com.example.compose_animation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose_animation.ui.theme.BarColor

@Composable
fun DrawScreen(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BarColor)
    ){
        Canvas(
            modifier = Modifier
                .padding(8.dp)
                .aspectRatio(3 / 2F)
                .fillMaxSize(),
            contentDescription = "",
            ){
            val barWidth = 1.dp.toPx()
            drawRect(
                Color.Gray,
                style = Stroke(barWidth)
            )
            val verticalLines = 4
            val verticalSize = size.width/(verticalLines+1)
            repeat(verticalLines){i->
                val startX = verticalSize*(i+1)
                drawLine(
                    color = BarColor,
                    startX = Offset(startX, 0F),
                    end = Offset(startX, size.height),
                    strokeWidth = barWidth
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewDrawScreen(){
    DrawScreen(navController = rememberNavController())
}