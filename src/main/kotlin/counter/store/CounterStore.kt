package counter.store

import simpleflux.stores.EventEmmiter

/**
 * Created by rick on 2017/6/24.
 */


const val CHANGE_EVENT = "CHANGE_EVENT"

object CounterStore : EventEmmiter() {
   val counterValues = mutableMapOf("First" to 0, "Second" to 10, "Third" to 30)

    fun emitChange(){
       emit(CHANGE_EVENT)
    }

    fun addChangeListener(callback:()->Unit) {
        on(CHANGE_EVENT, callback)
    }

    fun removeChangeListener(callback: () -> Unit) {
        off(CHANGE_EVENT, callback)
    }
}
