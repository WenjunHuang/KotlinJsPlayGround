package simpleflux.views

import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.span
import kotlin.browser.document

/**
 * Created by rick on 2017/6/23.
 */
class ItemCountView(val count: Int) {
    fun view() = document.create.div {
        span {
            +"$count"
        }
    }
}