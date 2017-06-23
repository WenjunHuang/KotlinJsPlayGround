package simpleflux.views

import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.li
import kotlinx.html.ul

/**
 * Created by rick on 2017/6/23.
 */

class ItemListView(val items: List<String>) {
    fun view() = kotlin.browser.document.create.div {
        ul {
            items.forEachIndexed { index, item ->
                li {
                    text(item)
                }
            }
        }
    }
}
