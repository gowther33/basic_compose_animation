package com.example.compose_animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose_animation.ui.theme.Compose_animationTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_animationTheme {
                navController = rememberNavController()
                HomeScreen(navHostController = navController)
                SetupNavGraph(navController = navController)
            }
        }
    }


    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun TestAnimations(){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var isVisible by remember {
                mutableStateOf(false)
            }
            var isRound by remember {
                mutableStateOf(false)
            }
            Button(onClick = {
                isVisible = !isVisible
                isRound = !isRound
            }) {
                Text(text = "Toggle")
            }

            // fades in and out the box based on state change
//                    AnimatedVisibility(
//                        visible = isVisible,
//                        enter = slideInHorizontally() + fadeIn(),
//                        exit = slideOutHorizontally() + fadeOut(),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                    ) {
//                        Box(modifier = Modifier.background(Color.Blue))
//                    }

            // switches between square and cirlce based on isRound
//                    val borderRadius by animateIntAsState(
//                        targetValue = if(isRound) 100 else 0,
//                        animationSpec = tween(
//                            durationMillis = 2000
//                        )
//                    )
//                    Box(
//                        modifier = Modifier
//                            .size(200.dp)
//                            .clip(RoundedCornerShape(borderRadius))
//                            .background(Color.Cyan)
//                    )

            // infinite animation
//                    val transition = rememberInfiniteTransition()
//                    val color by transition.animateColor(
//                        initialValue = Color.Red,
//                        targetValue = Color.Green,
//                        animationSpec = infiniteRepeatable(
//                            animation = tween(2000),
//                            repeatMode = RepeatMode.Reverse
//                        ),
//                        label = ""
//                    )
//                    Box(
//                        modifier = Modifier
//                            .size(200.dp)
//                            .clip(RoundedCornerShape(50))
//                            .background(color)
//                    )

            // Animated Content
            AnimatedContent(
                targetState = isVisible,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                content = {isVisible ->
                    if (isVisible){
                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .background(Color.Red)
                        )
                    }else{
                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .background(Color.Green)
                        )
                    }
                },
                transitionSpec = {
                    slideInHorizontally(
                        initialOffsetX = {
                            -it
                        }
                    ) with slideOutHorizontally(
                        targetOffsetX = {
                            it
                        }
                    )
                }
            )
        }
    }
}

