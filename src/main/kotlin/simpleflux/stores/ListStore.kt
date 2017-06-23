package simpleflux.stores

/**
 * Created by rick on 2017/6/23.
 */

class ListStore {
    val EventType = "ListStoreChange"
    private val items = mutableListOf<String>()
    private val listeners = mutableListOf<(String, ListStore) -> Unit>()

    fun getItems() = items

    fun itemCount() = items.size

    fun addNewItem(newItem: String) {
        items.add(newItem)
    }

    fun deleteItem(item: String) {
        items.remove(item)
    }

    fun first():String? {
        return items.firstOrNull()
    }

    fun addListener(listener: (String, ListStore) -> Unit) {
        listeners.add(listener)
    }

    fun removeListener(listener: (String, ListStore) -> Unit) {
        listeners.remove(listener)
    }

    fun emitChange() {
        listeners.forEach { listener ->
            listener(EventType, this)
        }
    }
}
