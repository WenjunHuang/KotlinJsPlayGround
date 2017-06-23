package simpleflux

/**
 * Created by rick on 2017/6/23.
 */

object ButtonActions {
    fun addNewItem(newItem:String) {
        AppDispatcher.action("ADD_NEW_ITEM",newItem)
    }

    fun deleteItem() {
        AppDispatcher.action("DELETE_ITEM","")
    }
}
