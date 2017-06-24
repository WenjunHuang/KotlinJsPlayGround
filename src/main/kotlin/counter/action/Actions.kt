package counter.action

import counter.store.CounterStore
import simpleflux.action.Action

/**
 * Created by rick on 2017/6/24.
 */

fun CounterStore.counterActions(action: Action) {
    if (action is IncrementAction) {
        if (counterValues.containsKey(action.counterCaption)) {
            counterValues[action.counterCaption] = counterValues[action.counterCaption]!! + 1
            emitChange()
        }
    } else if (action is DecrementAction) {
        if (counterValues.containsKey(action.counterCaption)) {
            counterValues[action.counterCaption] = counterValues[action.counterCaption]!! - 1
            emitChange()
        }
    }
}
