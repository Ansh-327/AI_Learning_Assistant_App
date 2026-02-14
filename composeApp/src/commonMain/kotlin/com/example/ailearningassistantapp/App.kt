package com.example.ailearningassistantapp

import androidx.compose.runtime.*
import com.example.ailearningassistantapp.presentation.*
import com.example.ailearningassistantapp.viewmodel.AiViewModel
import kotlinx.coroutines.delay

enum class Screen {
    SPLASH,
    LOGIN,
    SIGNUP,
    HOME
}

@Composable
fun App(
    authManager: AuthManager,
    aiViewModel: AiViewModel   // ✅ yeh already sahi hai
) {
    var currentScreen by remember { mutableStateOf(Screen.SPLASH) }

    // 🔥 Auto-login logic
    LaunchedEffect(Unit) {
        delay(1500)
        currentScreen =
            if (authManager.isUserLoggedIn()) {
                Screen.HOME
            } else {
                Screen.LOGIN
            }
    }

    when (currentScreen) {

        Screen.SPLASH -> {
            SplashScreen()
        }

        Screen.LOGIN -> {
            LoginScreen(
                onSignupClick = {
                    currentScreen = Screen.SIGNUP
                },
                onLoginClick = { email, password ->
                    authManager.login(
                        email = email,
                        password = password,
                        onSuccess = {
                            currentScreen = Screen.HOME
                        },
                        onError = {
                            println(it)
                        }
                    )
                }
            )
        }

        Screen.SIGNUP -> {
            SignupScreen(
                onSignupClick = { email, password ->
                    authManager.signup(
                        email = email,
                        password = password,
                        onSuccess = {
                            currentScreen = Screen.LOGIN
                        },
                        onError = {
                            println(it)
                        }
                    )
                },
                onLoginClick = {
                    currentScreen = Screen.LOGIN
                }
            )
        }

        Screen.HOME -> {
            HomeScreen(
                aiViewModel = aiViewModel,   // ✅ ⭐ THIS WAS MISSING
                onLogoutClick = {
                    authManager.logout()
                    currentScreen = Screen.LOGIN
                }
            )
        }
    }
}
