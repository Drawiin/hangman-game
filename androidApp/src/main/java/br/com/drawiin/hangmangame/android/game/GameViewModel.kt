package br.com.drawiin.hangmangame.android.game

import androidx.lifecycle.ViewModel
import br.com.drawiin.hangmangame.android.StateViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel(), StateViewModel<GameState, GameEffects, GameActions> {
    override val state: StateFlow<GameState>
        get() = TODO("Not yet implemented")
    override val effects: SharedFlow<GameEffects>
        get() = TODO("Not yet implemented")

    override fun onAction(action: GameActions) {
        TODO("Not yet implemented")
    }
}

data class GameState(
    val hangman: HangmanState,
    val wordLetters: List<GameLetter>,
    val availableLetters: List<GameLetter>
)

sealed interface GameEffects {
    object CloseGame : GameEffects
}

sealed interface GameActions {
    object GuessLetter
}

sealed interface GameLetter {
    data class Visible(val letter: Char) : GameLetter
    object Hidden : GameLetter
}

enum class HangmanState(val errorCount: Int) {
    EMPTY(0),
    ROPE(1),
    HEAD(2),
    BODY(3),
    LEFT_ARM(4),
    RIGHT_ARM(5),
    LEFT_LEG(6),
    RIGHT_LEG(7),
    HANGED(8);
}

sealed interface GuessLetter {
    val letter: Char

    data class Available(override val letter: Char) : GuessLetter
    data class Unavailable(override val letter: Char) : GuessLetter
}