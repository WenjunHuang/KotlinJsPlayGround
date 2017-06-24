package counter.store

import simpleflux.stores.EventEmmitter


/**
 * Created by rick on 2017/6/24.
 */


const val CounterChangedEvent = "CounterChangedEvent"

object CounterStore : EventEmmitter() {
    lateinit var DispatchToken: String

    val counterValues = mutableMapOf("First" to 0, "Second" to 10, "Third" to 30)


    fun addChangeListener(callback: () -> Unit) {
        on(CounterChangedEvent, callback)
    }

    fun removeChangeListener(callback: () -> Unit) {
        off(CounterChangedEvent, callback)
    }

    fun incrementByOne(counterCaption: String) {
        counterValues[counterCaption]?.let {
            counterValues[counterCaption] = it + 1
            emit(CounterChangedEvent)
        }
    }

    fun decrementByOne(counterCaption: String) {
        counterValues[counterCaption]?.let {
            counterValues[counterCaption] = counterValues[counterCaption]!! - 1
            emit(CounterChangedEvent)
        }
    }
}
