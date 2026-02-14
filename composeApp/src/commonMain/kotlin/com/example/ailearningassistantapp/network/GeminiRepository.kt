package com.example.ailearningassistantapp.network

import com.example.ailearningassistantapp.config.AiConfig
import com.example.ailearningassistantapp.model.Content
import com.example.ailearningassistantapp.model.GeminiRequest
import com.example.ailearningassistantapp.model.GeminiResponse
import com.example.ailearningassistantapp.model.Part
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class GeminiRepository(
    private val client: HttpClient
) {

    suspend fun askGemini(question: String): String {
        return try {

            val response: GeminiResponse = client.post(
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent"
            ) {
                parameter("key", AiConfig.GEMINI_API_KEY)
                contentType(ContentType.Application.Json)

                setBody(
                    GeminiRequest(
                        contents = listOf(
                            Content(
                                parts = listOf(
                                    Part(text = question)
                                )
                            )
                        )
                    )
                )
            }.body()

            response.candidates
                .firstOrNull()
                ?.content
                ?.parts
                ?.firstOrNull()
                ?.text
                ?: "⚠️ AI replied but no text found."

        } catch (e: Exception) {
            "❌ Gemini error: ${e.message ?: "Something went wrong"}"
        }
    }
}
