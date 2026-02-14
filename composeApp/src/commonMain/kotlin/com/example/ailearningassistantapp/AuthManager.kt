package com.example.ailearningassistantapp

interface AuthManager {

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )

    fun signup(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )

    fun logout()

    // 🔥 AUTO-LOGIN KEY
    fun isUserLoggedIn(): Boolean
}
