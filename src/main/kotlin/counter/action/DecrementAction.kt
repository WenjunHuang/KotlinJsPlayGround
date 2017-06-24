package counter.action

import simpleflux.action.Action

/**
 * Created by rick on 2017/6/24.
 */

const val Decrement:String = "DECREMENT"
class DecrementAction(val counterCaption:String) : Action(Decrement){}
