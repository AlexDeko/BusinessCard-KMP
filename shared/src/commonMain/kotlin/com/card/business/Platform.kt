package com.card.business

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform