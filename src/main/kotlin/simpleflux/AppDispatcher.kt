package simpleflux

import simpleflux.action.Action
import kotlin.js.Math

/**
 * Created by rick on 2017/6/23.
 */

object AppDispatcher {
    var callbacks = mutableMapOf<String, (Action) -> Unit>()

    fun register(callback: (action: Action) -> Unit): String {
        val token = generateToken()

        callbacks[token] = callback

        return token
    }

    fun dispatch(action: Action) {
        beginDispatch(action)

        callbacks.forEach { (id, _) ->
            invokeCallback(id)
        }

        endDispatch()
    }

    fun waitFor(token: String) {
        if (currentAction == null)
            throw IllegalStateException("waitFor must be called at dispatching")
        if (!callbacks.containsKey(token))
            throw IllegalArgumentException("can not find callback id: $token")

        invokeCallback(token)
    }

    private fun generateToken() = Math.random().toString()

    private fun beginDispatch(action: Action) {
        currentAction = action
    }

    private fun invokeCallback(token: String) {
        if (!tempCalledLogs.contains(token)) {
            callbacks[token]!!.invoke(currentAction!!)
            tempCalledLogs.add(token)
        }
    }

    private fun endDispatch() {
        tempCalledLogs.clear()
        currentAction = null
    }

    private var currentAction: Action? = null
    private val tempCalledLogs = mutableListOf<String>()
}
