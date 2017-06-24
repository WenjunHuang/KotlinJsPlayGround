package simpleflux.stores

/**
 * Created by rick on 2017/6/24.
 */

abstract class EventEmmitter {
    internal var callbacks: MutableMap<String, List<() -> Unit>> = mutableMapOf()

    fun on(event: String, fn: () -> Unit): EventEmmitter {
        val listeners = callbacks[event] ?: listOf<() -> Unit>()
        callbacks[event] = listeners + fn
        return this
    }

    fun off(event: String, fn: () -> Unit): EventEmmitter {
        callbacks[event] = callbacks.getOrDefault(event, listOf()) - fn
        return this
    }

    fun once(event: String, fn: () -> Unit): EventEmmitter {
        var wrapper: (() -> Unit)? = null
        wrapper = {
            fn()
            off(event, wrapper!!)
        }

        on(event, wrapper)
        return this
    }

    fun emit(event: String) {
        callbacks[event]?.let {
            it.forEach { callback -> callback() }
        }
    }
}