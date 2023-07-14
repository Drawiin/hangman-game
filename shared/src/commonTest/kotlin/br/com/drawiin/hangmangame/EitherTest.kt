package br.com.drawiin.hangmangame

import br.com.drawiin.hangmangame.Either.Failure
import br.com.drawiin.hangmangame.Either.Success
import kotlin.test.Test
import kotlin.test.assertEquals

class EitherTest {
    @Test
    fun `should return Failure when flatMap Failure`() {
        val failure: Either<String, String> = Failure("error")

        val mapped = failure.flatMap { Success(it) }

        assertEquals(mapped, failure)
    }

    @Test
    fun `should return Success when flatMap Success`() {
        val success: Either<String, String> = Success("success")

        val mapped = success.flatMap { Success(it+ "ful") }

        assertEquals(mapped, Success("successful"))
    }
}