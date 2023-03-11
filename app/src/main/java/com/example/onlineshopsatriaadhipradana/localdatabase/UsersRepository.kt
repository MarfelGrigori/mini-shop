package com.example.onlineshopsatriaadhipradana.localdatabase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val database: MyDatabase
) {

    private val dao = database.itemDAO()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(item: User) {
        ioScope.launch { dao.insert(item) }
    }

    fun loadAll(block: (List<User>) -> Unit) {
        ioScope.launch { block(withContext(Dispatchers.IO) { dao.getAll() }) }
    }

    fun delete(item: User) {
        ioScope.launch { dao.delete(item) }
    }

    fun update(item: User) {
        ioScope.launch { dao.update(item) }
    }

    fun fiendItem(itemName: String, block: (List<User>) -> Unit) {
        ioScope.launch { block(withContext(Dispatchers.IO) { dao.fiendItem(itemName) }) }
    }

    fun fiendById(id: Int, block: (List<User>) -> Unit) {
        ioScope.launch { block(withContext(Dispatchers.IO) { dao.getItemById(id) }) }
    }

}