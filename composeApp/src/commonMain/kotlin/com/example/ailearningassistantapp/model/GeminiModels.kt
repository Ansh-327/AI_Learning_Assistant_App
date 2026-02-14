package com.example.ailearningassistantapp.model

import kotlinx.serialization.Serializable

/* ---------- REQUEST ---------- */

@Serializable
data class GeminiRequest(
    val contents: List<Content>
)

@Serializable
data class Content(
    val parts: List<Part>
)

@Serializable
data class Part(
    val text: String
)

/* ---------- RESPONSE ---------- */

@Serializable
data class GeminiResponse(
    val candidates: List<Candidate> = emptyList()
)

@Serializable
data class Candidate(
    val content: Content? = null
)
