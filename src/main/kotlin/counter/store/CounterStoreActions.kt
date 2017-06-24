package counter.store

import simpleflux.AppDispatcher
import simpleflux.action.Action

/**
 * Created by rick on 2017/6/24.
 */
const val Decrement: String = "Decrement"
const val Increment: String = "Increment"

class DecrementAction(val counterCaption: String) : Action(Decrement)
class IncrementAction(val counterCaption: String) : Action(Increment)

object CounterStoreActions {
    fun increment(counterCaption: String) {
        AppDispatcher.dispatch(IncrementAction(counterCaption))
    }

    fun decrement(counterCaption: String) {
        AppDispatcher.dispatch(DecrementAction(counterCaption))

    }
}

fun CounterStore.counterActions(action: Action) {
    if (action is IncrementAction) {
        incrementByOne(action.counterCaption)
    } else if (action is DecrementAction) {
        decrementByOne(action.counterCaption)
    }
}
