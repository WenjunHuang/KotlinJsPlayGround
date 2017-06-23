package simpleflux

import simpleflux.stores.ListStore
import simpleflux.views.ItemAddDeleteViewController
import simpleflux.views.ItemCountViewController
import simpleflux.views.ItemListViewController
import kotlin.browser.document

/**
 * Created by rick on 2017/6/23.
 */

object Main {
    fun run() {
        val listStore = ListStore()
        AppDispatcher.action = { event, data ->
            when (event) {
                "ADD_NEW_ITEM" -> {
                    listStore.addNewItem(data + listStore.itemCount())
                    listStore.emitChange()
                }
                "DELETE_ITEM" -> {
                    if (listStore.first() != null) {
                        listStore.deleteItem(listStore.first()!!)
                        listStore.emitChange()
                    }
                }
            }
        }

        val listViewController = ItemListViewController(listStore)
        val addDeleteController = ItemAddDeleteViewController(listStore)
        val countController = ItemCountViewController(listStore)

        document.body!!.appendChild(listViewController.render())
        document.body!!.appendChild(addDeleteController.render())
        document.body!!.appendChild(countController.render())
    }
}
