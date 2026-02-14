package com.example.ailearningassistantapp

import com.google.firebase.auth.FirebaseAuth

class AuthManagerAndroid : AuthManager {

    private val auth = FirebaseAuth.getInstance()

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) onSuccess()
                else onError(task.exception?.message ?: "Login failed")
            }
    }

    override fun signup(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) onSuccess()
                else onError(task.exception?.message ?: "Signup failed")
            }
    }

    override fun logout() {
        auth.signOut()
    }

    // 🔥 AUTO-LOGIN CHECK
    override fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}
