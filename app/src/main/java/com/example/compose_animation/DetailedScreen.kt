package com.example.compose_animation

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import java.text.SimpleDateFormat
import java.time.LocalDate

@Composable
fun DetailedScreen(
    navHostController: NavHostController,
    data:String = "empty"
){
    val time = Calendar.getInstance().time
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
    val current = formatter.format(time)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Detail Screen",
            color = Color.Green,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
        Text(
            text = data,
            color = Color.DarkGray,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace
        )
        Button(
            onClick = {
                navHostController.previousBackStackEntry?.savedStateHandle?.set("date", current)
                navHostController.popBackStack()
            },
        ) {
            Text(text = "Back")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun  DetailedPreview() {
    DetailedScreen(
        rememberNavController()
    )
}