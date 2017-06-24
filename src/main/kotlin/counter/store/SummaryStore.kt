package counter.store

import simpleflux.stores.EventEmmitter

/**
 * Created by rick on 2017/6/24.
 */
const val SummaryChangedEvent = "SummaryChangedEvent"

object SummaryStore : EventEmmitter() {
    lateinit var DispatchToken : String

    fun getSummary(): Int {
        return CounterStore.counterValues.values.sum()
    }

    fun summaryChanged() {
        emit(SummaryChangedEvent)
    }

    fun addChangeListener(callback: () -> Unit) {
        on(SummaryChangedEvent, callback)
    }

    fun removeChangeListener(callback: () -> Unit) {
        off(SummaryChangedEvent, callback)
    }
}