package counter

import counter.store.DecrementAction
import counter.store.IncrementAction
import counter.store.CounterStore
import kotlinx.html.button

import kotlinx.html.div
import kotlinx.html.js.onClickFunction
import kotlinx.html.span
import react.*
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent
import simpleflux.AppDispatcher

/**
 * Created by rick on 2017/6/24.
 */

class Counter : ReactDOMComponent<Counter.Props, Counter.State>() {
    companion object : ReactComponentSpec<Counter, Props, State>

    init {
        state = State(CounterStore.counterValues[props.caption]!!)
        CounterStore.addChangeListener {
            setState {
                counter = CounterStore.counterValues[props.caption]!!
            }
        }
    }

    override fun ReactDOMBuilder.render() {
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
        println("called updateCounter")
        AppDispatcher.dispatch(if (increment) IncrementAction(props.caption) else DecrementAction(props.caption))
    }


    override fun componentWillUpdate() {
        println("enter componentWillUpdate")
    }

    override fun componentDidUpdate(prevProps: Props, prevState: State) {
        println("enter componentDidUpdate")
    }

    override fun componentWillReceiveProps(nextProps: Props) {
        println("enter componentWillReceiveProps")
    }

    override fun componentWillMount() {
        println("enter componentWillMount")
    }

    override fun componentDidMount() {
        println("enter componentDidMount")
    }

    override fun shouldComponentUpdate(nextProps: Props, nextState: State): Boolean {
        return nextProps.caption != props.caption || state.counter != nextState.counter
    }


    data class State(var counter: Int = 0) : RState
    data class Props(val caption: String) : RProps()

}

