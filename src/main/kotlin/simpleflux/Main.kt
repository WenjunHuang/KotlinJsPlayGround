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
        addControllersToDom(initializeStores())
    }

    private fun initializeStores(): ListStore {
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
        return listStore
    }

    private fun addControllersToDom(listStore: ListStore) {
        val listViewController = ItemListViewController(listStore)
        val addDeleteController = ItemAddDeleteViewController(listStore)
        val countController = ItemCountViewController(listStore)

        with(document.querySelector("#app")!!) {
            appendChild(countController.render())
            appendChild(addDeleteController.render())
            appendChild(listViewController.render())
        }
    }
}
