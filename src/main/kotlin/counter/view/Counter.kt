package counter.view

import counter.store.CounterStore
import counter.store.CounterStoreActions
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.js.onClickFunction
import kotlinx.html.span

/**
 * Created by rick on 2017/6/24.
 */

class Counter : react.dom.ReactDOMComponent<Counter.Props, Counter.State>() {
    companion object : react.ReactComponentSpec<Counter, Props, State>

    init {
        state = State(CounterStore.counterValues[props.caption]!!)
    }

    override fun react.dom.ReactDOMBuilder.render() {
        println("enter render ${props.caption}")
        div {
            button(classes = "chap02-btn") {
                +"+"
                onClickFunction = {
                    updateCounter(true)
                }
            }

            button(classes = "chap02-btn") {
                +"-"
                onClickFunction = {
                    updateCounter(false)
                }
            }

            span {
                +"${props.caption} count: ${state.counter}"
            }
        }
    }

    private fun updateCounter(increment: Boolean) {
        if (increment)
            CounterStoreActions.increment(props.caption)
        else
            CounterStoreActions.decrement(props.caption)
    }


    override fun componentWillUpdate() {
    }

    override fun componentDidUpdate(prevProps: counter.view.Counter.Props, prevState: counter.view.Counter.State) {
    }

    override fun componentWillReceiveProps(nextProps: counter.view.Counter.Props) {
    }

    override fun componentWillMount() {
    }

    override fun componentDidMount() {
        CounterStore.addChangeListener(this::onCounterStoreChanged)
    }

    override fun componentWillUnmount() {
        CounterStore.removeChangeListener(this::onCounterStoreChanged)
    }

    override fun shouldComponentUpdate(nextProps: counter.view.Counter.Props, nextState: counter.view.Counter.State): Boolean {
        return nextProps.caption != props.caption || state.counter != nextState.counter
    }

    private fun onCounterStoreChanged() {
        setState {
            counter = CounterStore.counterValues[props.caption]!!
        }
    }


    data class State(var counter: Int = 0) : react.RState
    data class Props(val caption: String) : react.RProps()

}

