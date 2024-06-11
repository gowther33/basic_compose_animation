package com.example.compose_animation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
        Spacer(
            modifier = Modifier
                .padding(8.dp)
                .aspectRatio(3 / 2F)
                .fillMaxSize()
                .align(Alignment.Center)
                .drawWithCache {
                    onDrawBehind {

                        val graphData = listOf(
                            Pair(10F, 5F),
                            Pair(20F, 14F),
                            Pair(89F, 66F),
                            Pair(100F, 70F),
                            Pair(110F, 89F),
                            Pair(200F, 170F),
                            Pair(220F, 180F),
                        )
                        val path = generatePath(graphData, size)
                        // Grid drawing logic
                        val barWidth = 1.dp.toPx()
                        drawRect(
                            Color.Gray,
                            style = Stroke(barWidth)
                        )
                        // Vertical lines
                        val verticalLines = 4
                        val verticalSize = size.width/(verticalLines+1)
                        repeat(verticalLines){i->
                            val startX = verticalSize*(i+1)
                            drawLine(
                                color = Color.Gray,
                                start = Offset(startX, 0F),
                                end = Offset(startX, size.height),
                                strokeWidth = barWidth
                            )
                        }
                        // Horizontal lines
                        val horizontalLines = 3
                        val sectionSize = size.height/(horizontalLines+1)
                        repeat(horizontalLines){i->
                            val startY = sectionSize*(i+1)
                            drawLine(
                                color = Color.Gray,
                                start = Offset(0F, startY),
                                end = Offset(size.width, startY),
                                strokeWidth = barWidth
                            )
                        }
                        // Graph line
                        drawPath(path, Color.Green,
                            style = Stroke(2.dp.toPx()))
                    }
                }
            )
    }
}

fun generatePath(list:List<Pair<Float,Float>>, size:Size):Path{
    val path = Path()

    list.forEach {data ->
        val x = data.first
        val y = data.second
        path.lineTo(x, y)
    }

    return path
}

@Composable
@Preview(showBackground = true)
fun PreviewDrawScreen(){
    DrawScreen(navController = rememberNavController())
}