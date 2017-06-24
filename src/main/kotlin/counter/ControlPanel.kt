package counter

import kotlinx.html.div
import kotlinx.html.hr
import react.*
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent

/**
 * Created by rick on 2017/6/24.
 */

class ControlPanel : ReactDOMComponent<ReactComponentNoProps, ControlPanel.State>() {
    companion object : ReactComponentSpec<ControlPanel, ReactComponentNoProps, State>

    val initValues = arrayOf(0,10,20)

    init {
        state = State(initValues.sum())
    }

    override fun ReactDOMBuilder.render() {
        div(classes = "chap02-controlPanel") {
            Counter(Counter.Props("First", initValues[0])) {}
            Counter(Counter.Props("Second", initValues[1])) {}
            Counter(Counter.Props("Third", initValues[2])) {}

            hr {}
            div {
                +"Total Count: ${state.sum}"
            }
        }
    }

    fun onCounterUpdate(newValue:Int, oldValue:Int) {
       val dif = newValue - oldValue
        setState {
            sum = state.sum + dif
        }
    }

    data class State(var sum:Int = 0):RState
}
