package counter

import counter.store.SummaryStore
import kotlinx.html.div
import kotlinx.html.hr
import react.RState
import react.ReactComponentNoProps
import react.ReactComponentSpec
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent

/**
 * Created by rick on 2017/6/24.
 */

class ControlPanel : ReactDOMComponent<ReactComponentNoProps, ControlPanel.State>() {
    companion object : ReactComponentSpec<ControlPanel, ReactComponentNoProps, State>

    init {
        state = State(SummaryStore.getSummary())
        SummaryStore.addChangeListener {
            setState {
                sum = SummaryStore.getSummary()
            }
        }
    }

    override fun ReactDOMBuilder.render() {
        div(classes = "chap02-controlPanel") {
            Counter(Counter.Props("First")) {}
            Counter(Counter.Props("Second")) {}
            Counter(Counter.Props("Third")) {}

            hr {}
            div {
                +"Total Count: ${state.sum}"
            }
        }
    }

    data class State(var sum: Int = 0) : RState
}
