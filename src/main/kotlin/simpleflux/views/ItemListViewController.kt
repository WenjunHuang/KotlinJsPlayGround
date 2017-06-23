package simpleflux.views

import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlinx.html.*
import kotlinx.html.dom.*
import org.w3c.dom.HTMLElement
import simpleflux.ButtonActions
import simpleflux.stores.ListStore

/**
 * Created by rick on 2017/6/23.
 */
class ItemListViewController(val listStore: ListStore) {
    val container = document.body!!.append.div {}

    init {
        listStore.addListener(this::onChange)
    }

    fun onChange(event: String, store: ListStore) {
        refresh()
    }

    fun refresh() {
        while (container.firstChild != null)
            container.removeChild(container.firstChild!!)

        container.appendChild(ItemListView(listStore.getItems()).view())
    }

    fun render(): HTMLElement {
        refresh()
        return container
    }
}