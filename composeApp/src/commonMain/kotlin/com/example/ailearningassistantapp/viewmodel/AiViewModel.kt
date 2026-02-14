package com.example.ailearningassistantapp.viewmodel

import kotlinx.coroutines.flow.StateFlow

expect class AiViewModel {

    val userQuestion: StateFlow<String>
    val aiAnswer: StateFlow<String>
    val isLoading: StateFlow<Boolean>

    fun onQuestionChange(text: String)
    fun askAi()
}
