import counter.ControlPanel
import counter.store.counterActions
import counter.store.CounterStore
import counter.store.SummaryStore
import counter.store.summaryActions
import kotlinx.html.div
import react.dom.ReactDOM
import react.dom.render
import simpleflux.AppDispatcher
import kotlin.browser.document

/**
 * Created by rick on 2017/6/24.
 */

fun main(args: Array<String>) {
    SummaryStore.DispatchToken = AppDispatcher.register(SummaryStore::summaryActions)
    CounterStore.DispatchToken = AppDispatcher.register(CounterStore::counterActions)

    ReactDOM.render(document.getElementById("app")) {
        div {
            ControlPanel {}
        }
    }
}
