package br.com.drawiin.hangmangame.android.game

fun interface GetGameWordUseCase {
    suspend operator fun invoke(): List<GameLetter>
}