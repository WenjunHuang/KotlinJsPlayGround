package simpleflux.views

import kotlinx.html.*
import kotlinx.html.dom.*
import kotlinx.html.js.*
import org.w3c.dom.HTMLElement
import simpleflux.stores.ListStore
import kotlin.browser.document

/**
 * Created by rick on 2017/6/23.
 */

class ItemCountViewController(val listStore: ListStore) {
    val container = document.create.div {
        this
    }

    init {
        listStore.addListener { s, listStore ->
            refresh()
        }
    }

    fun refresh() {
        while (container.firstChild != null) {
            container.removeChild(container.firstChild!!)
        }

        with(container) {
            appendChild(ItemCountView(listStore.itemCount()).view())
        }
    }

    fun render(): HTMLElement {
        refresh()
        return container
    }
}
