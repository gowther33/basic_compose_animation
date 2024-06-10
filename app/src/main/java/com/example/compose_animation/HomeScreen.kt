package com.example.compose_animation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(
    navHostController: NavHostController
){
    var txt by remember {
        mutableStateOf("")
    }
    var date = navHostController.currentBackStackEntry?.savedStateHandle?.get<String>("date")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
fun HomeScreen(){
    val brush = Brush.linearGradient(
        listOf(
            Color.Red,
            Color.Blue,
            Color.Green
        )
    )
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val rotationTransition = infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            tween(1000, easing = LinearEasing)
        ), label = ""
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = txt,
            placeholder = {
                if (date!=null){
                    Text(date)
                }else{
                    Text("Type here...")
                }
            },
            onValueChange = {
                txt = it
            }
        )
        Text(
            text = "Home Screen",
            color = Color.Green,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
        Button(
            onClick = {
                navHostController.navigate(
                    route = "${Screen.Detail.route}/$txt"
                )
            },
            ) {
            Text(text = "Next")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun  HomePreview() {
    HomeScreen(
        rememberNavController()
    )
}