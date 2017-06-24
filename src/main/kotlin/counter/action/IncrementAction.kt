package counter.action

import simpleflux.action.Action

/**
 * Created by rick on 2017/6/24.
 */

const val Increment:String = "INCREMENT"
class IncrementAction(val counterCaption:String): Action(Increment) {
}
