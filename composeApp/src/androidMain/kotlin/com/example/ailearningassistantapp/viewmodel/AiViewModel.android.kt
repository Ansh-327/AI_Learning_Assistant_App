package com.example.ailearningassistantapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ailearningassistantapp.network.GeminiRepository
import com.example.ailearningassistantapp.network.HttpClientFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

actual class AiViewModel : ViewModel() {

    private val repository =
        GeminiRepository(HttpClientFactory.create())

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
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _aiAnswer.value =
                    repository.askGemini(_userQuestion.value)
            } catch (e: Exception) {
                _aiAnswer.value = "❌ ${e.message}"
            }
            _isLoading.value = false
        }
    }
}
