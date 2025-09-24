package com.example.kmpcursoudemygaston.utils

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform