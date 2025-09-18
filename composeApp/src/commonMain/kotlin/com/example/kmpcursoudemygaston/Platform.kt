package com.example.kmpcursoudemygaston

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform