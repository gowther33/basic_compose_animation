package com.example.compose_animation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
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