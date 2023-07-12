package br.com.drawiin.hangmangame.android

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * [StateViewModel] is a generic interface that all view models must complain to
 * @property state - the current screen state of type [S]
 * @property effects - single shot side effects of type [E] that only happens once (navigation, snackbars etc.)
 */
interface StateViewModel<S, E, A> {
    val state: StateFlow<S>
    val effects: SharedFlow<E>

    /**
     * [onAction] receives a action of type [A]
     */
    fun onAction(action: A)
}