package simpleflux.views

import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import kotlin.browser.document

/**
 * Created by rick on 2017/6/23.
 */
class ItemAddDeleteView(val onAdd: (Event) -> Unit, val onDelete: (Event) -> Unit) {
    fun view() = document.create.div {
        button {
            +"Add New Item"
            onClickFunction = onAdd
        }
        button {
            +"Delete Item"
            onClickFunction = onDelete
        }
    }
}