package simpleflux.views

import kotlinx.html.div
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import simpleflux.ButtonActions
import simpleflux.stores.ListStore
import kotlin.browser.document

/**
 * Created by rick on 2017/6/23.
 */
class ItemAddDeleteViewController(val listStore: ListStore) {
    val container = document.create.div {}

    fun onAddNewItem(event: Event) {
        ButtonActions.addNewItem("add new item")
    }

    fun onDeleteItem(event: Event) {
        ButtonActions.deleteItem()
    }

    fun render(): HTMLElement {
        container.appendChild(ItemAddDeleteView(this::onAddNewItem, this::onDeleteItem).view())
        return container
    }
}