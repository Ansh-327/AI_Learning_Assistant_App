package com.example.ailearningassistantapp.network

import io.ktor.client.*

expect object HttpClientFactory {
    fun create(): HttpClient
}
