package counter.store

import simpleflux.action.Action

/**
 * Created by rick on 2017/6/24.
 */
const val Decrement:String = "DECREMENT"
class DecrementAction(val counterCaption:String) : Action(Decrement)
const val Increment:String = "INCREMENT"
class IncrementAction(val counterCaption:String): simpleflux.action.Action(counter.store.Increment)

fun CounterStore.counterActions(action: Action) {
    if (action is IncrementAction) {
        incrementByOne(action.counterCaption)
    } else if (action is DecrementAction) {
        decrementByOne(action.counterCaption)
    }
}
