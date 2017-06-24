package counter.store

import simpleflux.AppDispatcher
import simpleflux.action.Action

/**
 * Created by rick on 2017/6/24.
 */

fun SummaryStore.summaryActions(action: Action) {
    when (action.actionType) {
        Decrement, Increment -> {
            AppDispatcher.waitFor(CounterStore.DispatchToken)
            summaryChanged()
        }
    }
}
