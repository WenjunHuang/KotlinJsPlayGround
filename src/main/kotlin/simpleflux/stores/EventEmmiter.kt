package simpleflux.stores

/**
 * Created by rick on 2017/6/24.
 */

abstract class EventEmmiter {
    private val listeners = mutableMapOf<String, List<() -> Unit>>()

    fun on(event: String, callback: () -> Unit) {
        listeners[event] = listeners.getOrDefault(event, listOf()) + callback
    }

    fun off(event: String, callback: ()->Unit) {
        if (listeners.containsKey(event)) {
            listeners[event] = listeners[event]!! - callback
        }
    }

    fun emit(event: String) {
        listeners[event]?.forEach { listener -> listener() }
    }
}