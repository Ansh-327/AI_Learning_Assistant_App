package com.example.ailearningassistantapp.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

actual class AiViewModel {

    private val _userQuestion = MutableStateFlow("")
    private val _aiAnswer = MutableStateFlow("")
    private val _isLoading = MutableStateFlow(false)

    actual val userQuestion: StateFlow<String> = _userQuestion
    actual val aiAnswer: StateFlow<String> = _aiAnswer
    actual val isLoading: StateFlow<Boolean> = _isLoading

    actual fun onQuestionChange(text: String) {
        _userQuestion.value = text
    }

    actual fun askAi() {
        _isLoading.value = true
        _aiAnswer.value = "Gemini iOS integration pending 🚧"
        _isLoading.value = false
    }
}
