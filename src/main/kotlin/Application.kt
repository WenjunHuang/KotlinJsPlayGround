import counter.ControlPanel
import counter.action.counterActions
import counter.store.CounterStore
import kotlinx.html.div
import react.dom.ReactDOM
import react.dom.render
import simpleflux.AppDispatcher
import kotlin.browser.document

/**
 * Created by rick on 2017/6/24.
 */

fun main(args: Array<String>) {
    AppDispatcher.register(CounterStore::counterActions)

    ReactDOM.render(document.getElementById("app")) {
        div {
            ControlPanel {}
        }
    }
}
