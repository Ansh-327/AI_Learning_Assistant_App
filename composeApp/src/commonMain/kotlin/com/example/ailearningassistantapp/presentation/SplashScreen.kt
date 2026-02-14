package com.example.ailearningassistantapp.presentation

import ailearningassistantapp.composeapp.generated.resources.Res
import ailearningassistantapp.composeapp.generated.resources.splash_ai
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun SplashScreen() {

    // Gradient background
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0A1B4D),
            Color(0xFF0F2A6D),
            Color(0xFF08142E)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)

        ) {

            // Splash Image
            Image(
                painter = painterResource(Res.drawable.splash_ai),
                contentDescription = "AI Learning Assistant",
                modifier = Modifier
                    .size(260.dp)
                    .fillMaxWidth().clip(CircleShape)
            )


            Spacer(modifier = Modifier.height(32.dp))

            // App Name
            androidx.compose.material3.Text(
                text = "AI Learning Assistant",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Tagline
            androidx.compose.material3.Text(
                text = "Your Smart Study Buddy",
                fontSize = 16.sp,
                color = Color(0xFFB0C7FF),
                textAlign = TextAlign.Center
            )
        }
    }
}
