package simpleflux

import simpleflux.action.Action

/**
 * Created by rick on 2017/6/23.
 */

object AppDispatcher {
    var callbacks = mutableListOf<(Action) -> Unit>()

    fun register(callback: (action: Action) -> Unit) {
        callbacks.add(callback)
    }

    fun dispatch(action: Action) {
        callbacks.forEach { callback ->
            callback(action)
        }
    }
}
