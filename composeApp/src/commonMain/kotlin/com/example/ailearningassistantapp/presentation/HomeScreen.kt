package com.example.ailearningassistantapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import com.example.ailearningassistantapp.viewmodel.AiViewModel

/* -----------------------
   UI Model
------------------------ */
data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

/* -----------------------
   Home Screen (KMP UI)
------------------------ */
@Composable
fun HomeScreen(
    aiViewModel: AiViewModel,
    onLogoutClick: () -> Unit
) {

    val userQuestion by aiViewModel.userQuestion.collectAsState()
    val aiAnswer by aiViewModel.aiAnswer.collectAsState()
    val isLoading by aiViewModel.isLoading.collectAsState()


    var messages by remember {
        mutableStateOf(
            listOf(
                ChatMessage(
                    text = "Hi 👋 I’m your AI Learning Assistant. Ask me anything!",
                    isUser = false
                )
            )
        )
    }


    /* ---- AI answer listener (ONE-TIME ADD) ---- */
    LaunchedEffect(aiAnswer) {
        if (aiAnswer.isNotBlank()) {
            messages = messages + ChatMessage(
                text = aiAnswer,
                isUser = false
            )
        }
    }


    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0A1B4D),
            Color(0xFF08142E)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient)
    ) {

        /* -------- Top Bar -------- */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(16.dp)
        ) {
            Text(
                text = "AI Learning Assistant 🤖",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )

            Text(
                text = "Logout",
                color = Color(0xFFB0C7FF),
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable { onLogoutClick() }
            )
        }

        Divider(color = Color.White.copy(alpha = 0.15f))

        /* -------- Chat Area -------- */
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            reverseLayout = true
        ) {

            items(messages.reversed()) { message ->
                ChatBubble(message)
                Spacer(modifier = Modifier.height(8.dp))
            }

            if (isLoading) {
                item {
                    ChatBubble(
                        ChatMessage(
                            text = "AI is typing…",
                            isUser = false
                        )
                    )
                }
            }
        }

        /* -------- Input Area -------- */
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextField(
                value = userQuestion,
                onValueChange = {
                    aiViewModel.onQuestionChange(it)
                },
                placeholder = { Text("Ask something…") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(24.dp),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                shape = RoundedCornerShape(20.dp),
                onClick = {
                    if (userQuestion.isBlank()) return@Button

                    // User message
                    messages = messages + ChatMessage(userQuestion, true)

                    // Ask AI
                    aiViewModel.askAi()

                    // Clear input
                    aiViewModel.onQuestionChange("")
                }
            ) {
                Text("Send")
            }
        }
    }
}

/* -----------------------
   Chat Bubble
------------------------ */
@Composable
fun ChatBubble(message: ChatMessage) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
            if (message.isUser) Arrangement.End else Arrangement.Start
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color =
                if (message.isUser)
                    Color(0xFF4FC3F7)
                else
                    Color.White.copy(alpha = 0.95f),
            modifier = Modifier.widthIn(max = 260.dp)
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(12.dp),
                color =
                    if (message.isUser) Color.White else Color.Black,
                fontSize = 14.sp
            )
        }
    }
}
