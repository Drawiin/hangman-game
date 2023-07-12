package br.com.drawiin.hangmangame

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform