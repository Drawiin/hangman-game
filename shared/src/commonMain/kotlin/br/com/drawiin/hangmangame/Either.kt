package br.com.drawiin.hangmangame

import br.com.drawiin.hangmangame.Either.Failure
import br.com.drawiin.hangmangame.Either.Success

sealed interface Either<out S, out F> {
    data class Success<out S>(val value: S) : Either<S, Nothing>
    data class Failure<out F>(val error: F) : Either<Nothing, F>
}

inline fun <S, F, R> Either<S, F>.flatMap(transform: (S) -> Either<R, F>): Either<R, F> {
    return when (this) {
        is Success -> transform(this.value)
        is Failure -> this
    }
}