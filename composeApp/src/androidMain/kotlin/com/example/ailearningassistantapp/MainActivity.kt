package com.example.ailearningassistantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ailearningassistantapp.App
import com.example.ailearningassistantapp.AuthManagerAndroid
import com.example.ailearningassistantapp.viewmodel.AiViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val authManager = AuthManagerAndroid()
        val aiViewModel = AiViewModel()   // ✅ Android actual ViewModel

        setContent {
            App(
                authManager = authManager,
                aiViewModel = aiViewModel
            )
        }
    }
}
