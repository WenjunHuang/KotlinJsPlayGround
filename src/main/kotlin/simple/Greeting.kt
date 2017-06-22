package simple

import kotlin.browser.document
import kotlin.browser.window
import kotlinx.html.*
import kotlinx.html.dom.*

/**
 * Created by rick on 2017/6/22.
 */

fun sayHi() {
    document.body!!.append {
        div {
            span {
                +"Hello"
            }
        }
    }
}
