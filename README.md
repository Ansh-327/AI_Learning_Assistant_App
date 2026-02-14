# 🤖 AI Learning Assistant App (Kotlin Multiplatform)

An AI-powered **Learning Assistant App** built using **Kotlin Multiplatform (KMP)** and **Compose Multiplatform** & **AI Integration**, targeting **Android & iOS** from a shared codebase.

This project focuses on:
- ✨ Clean Multiplatform Architecture  
- 🚀 Shared UI with Compose Multiplatform  
- 🧠 AI (Gemini API) Integration  
- 🔐 Firebase Authentication  
- 📱 Real-world cross-platform development  

---

## 🌍 Platforms Supported
- ✅ Android
- ✅ iOS

---

## 📁 Project Structure (Simplified)


AILearningAssistantApp/
│
├── composeApp/ # Shared Multiplatform code
│ ├── commonMain/ # Shared UI, ViewModels, business logic
│ ├── androidMain/ # Android-specific implementations
│ └── iosMain/ # iOS-specific implementations
│
├── iosApp/ # Native iOS app (SwiftUI entry point)
│
└── build.gradle.kts # Project configuration



### 🔹 `composeApp`
This is the **heart of the project** ❤️  
All reusable UI, logic, and AI integration lives here.

- `commonMain` → shared across Android & iOS  
- `androidMain` → Android-only code  
- `iosMain` → iOS-only code  

### 🔹 `iosApp`

Native iOS entry point (Xcode project).

Responsible for:
- Managing the iOS app lifecycle
- Bootstrapping the application on iOS
- Rendering the **shared Compose Multiplatform UI from `commonMain`**

ℹ️ Note:  
No SwiftUI UI code is used.  
The complete UI is written once in `commonMain` and shared across **Android and iOS**.


---

## 🧠 AI Features
- Gemini API powered responses
- Real-time chat-style interface
- Compose-friendly state handling
- Error-safe API calls

---

## 🔐 Authentication
- Firebase Email/Password Authentication
- Auto-login handling
- Secure logout flow

---


# 📸 ScreenShot

<img width="487" height="1011" alt="Screenshot 2026-02-15 032910" src="https://github.com/user-attachments/assets/f5368882-6d99-457b-9d64-c37d67c110a9" />

<img width="495" height="1006" alt="Screenshot 2026-02-15 032717" src="https://github.com/user-attachments/assets/29a3f847-ba03-475b-819d-1495172efccf" />

<img width="488" height="1004" alt="Screenshot 2026-02-15 032924" src="https://github.com/user-attachments/assets/a85ec35c-a4fb-46c9-bd24-3b0542269a0e" />

<img width="489" height="1011" alt="Screenshot 2026-02-15 033000" src="https://github.com/user-attachments/assets/d7f1c7ba-8235-4d67-95f7-689241e8087c" />
